#!/usr/bin/env bash
set -euo pipefail

IMAGE="owasp/benchmark"
TAG="latest"
PLATFORMS="linux/amd64,linux/arm64"
BUILDER_NAME="benchmark-multiarch"

# Create (or re-use) a buildx builder that supports multi-platform builds.
if ! docker buildx inspect "$BUILDER_NAME" >/dev/null 2>&1; then
  echo "Creating buildx builder: $BUILDER_NAME"
  docker buildx create --name "$BUILDER_NAME" --use
else
  docker buildx use "$BUILDER_NAME"
fi

# Build and push a multi-architecture image in one step.
# --push is required because multi-arch manifest lists cannot be loaded into
# the local daemon. The image is pushed directly to Docker Hub.
echo "Building ${IMAGE}:${TAG} for ${PLATFORMS} ..."
docker buildx build \
  --platform "$PLATFORMS" \
  --tag "${IMAGE}:${TAG}" \
  --push \
  .

echo "Done. Published ${IMAGE}:${TAG} for ${PLATFORMS}."

