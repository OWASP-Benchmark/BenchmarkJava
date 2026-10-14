# Multi-Architecture Docker Image — Build and Publish Guide

This document accompanies PR #445, which switches the BenchmarkJava Docker image
to a multi-architecture (`linux/amd64` + `linux/arm64`) build via `docker buildx`.

## Summary

The published `owasp/benchmark:latest` Docker image was built on an ARM64 host,
making it `linux/arm64` only. On amd64 machines (the vast majority of CI runners
and developer workstations), Docker falls back to QEMU emulation, causing
startup times over 60 seconds — long enough to break downstream CI (e.g., ZAP
scans reported in #223).

The build tooling now uses `docker buildx build` with
`--platform linux/amd64,linux/arm64`. Docker Hub receives a single manifest
list that serves the native image for each architecture automatically.

## What changed

| File | Change |
|------|--------|
| `VMs/buildDockerImage.sh` | Rewritten to use `docker buildx build` with `--platform linux/amd64,linux/arm64`, `--file VMs/Dockerfile`, and context `VMs`. Builds and pushes a multi-arch manifest list to Docker Hub in one step. |
| `VMs/Dockerfile` | Collapsed multiple `RUN` layers into single chained commands; added `rm -rf /var/lib/apt/lists/*`; added `EXPOSE 8443` and `CMD ["./runBenchmark.sh"]` so the container starts the benchmark by default. Base image remains `ubuntu:latest` per maintainer preference. |
| `VMs/runDockerImage.sh` | Updated image tag from `benchmark` to `owasp/benchmark` to match the new build script's output. |
| `.github/workflows/docker-publish.yml` | New CI workflow (manual trigger only, inactive by default) for automated multi-arch builds. Activation steps below. |

## Manual build

Prerequisites: Docker with buildx support (Docker Desktop 19.03+ or Docker
Engine with the buildx plugin), and a Docker Hub login with push access to
the `owasp/benchmark` namespace:

```bash
docker login -u <your-dockerhub-username>
```

Then, from the **repository root**:

```bash
./VMs/buildDockerImage.sh
```

This builds for both amd64 and arm64 and pushes `owasp/benchmark:latest` to
Docker Hub. `--push` is required because multi-arch manifest lists cannot be
loaded into the local Docker daemon; build and push happen together.

## Running the published image

After publishing, run the image with:

```bash
./VMs/runDockerImage.sh
```

This pulls `owasp/benchmark:latest` from Docker Hub and starts the benchmark
inside the container.

## Activating the GitHub Actions workflow

The workflow file is at `.github/workflows/docker-publish.yml`, but it only
runs when manually dispatched until two activation steps are completed.

### Step 1: Add Docker Hub secrets

Go to **Settings > Secrets and variables > Actions** in the GitHub repository
and add:

| Secret name | Value |
|-------------|-------|
| `DOCKERHUB_USERNAME` | Docker Hub username |
| `DOCKERHUB_TOKEN` | Docker Hub access token (create at https://hub.docker.com/settings/security) |

### Step 2: Enable automatic triggers (optional)

Open `.github/workflows/docker-publish.yml` and uncomment the trigger lines:

```yaml
on:
  workflow_dispatch:
  # Uncomment when ready:
  push:
    branches: [master]
    paths: ['VMs/Dockerfile']
  release:
    types: [published]
```

This rebuilds and pushes the image whenever the Dockerfile is changed on
`master` or a new GitHub release is published.

### Step 3: Test with manual trigger first

Before enabling automatic triggers, verify the workflow manually:

1. Go to **Actions > Docker Publish** in the repository.
2. Click **Run workflow**.
3. Confirm both architectures appear with:

   ```bash
   docker manifest inspect owasp/benchmark:latest
   ```

   The output should list entries for both `amd64` and `arm64`.

## What was not changed

| Item | Reason |
|------|--------|
| JDK version (17) | Tracked separately in #227. |
| `bench:bench` user/password | Test image only, not a production deployment. |
| `timeout 60 ./runBenchmark.sh; exit 0` warm-up | Intentional — caches runtime dependencies into the image. |
