@echo off
REM Check for install/updates at https://github.com/bearer/bearer

where docker >nul 2>nul
IF %ERRORLEVEL% NEQ 0 (
  @echo docker required. Please install.
  exit /b
)

where sh >nul 2>nul
IF %ERRORLEVEL% NEQ 0 (
  @echo git bash is required. Please install.
  exit /b
)

docker pull bearer/bearer

for /f %%i in ('sh scripts/getBenchmarkVersion.sh') do set benchmark_version=%%i
for /f %%i in ('docker run bearer/bearer bearer --version ^| grep -o "[[:digit:]]\+\.[[:digit:]]\+\.[[:digit:]]\+"') do set bearer_version=%%i
set result_file="/src/results/Benchmark_%benchmark_version%-Bearer-v%bearer_version%.json"
set current_dir=%cd%

@echo on
docker run --rm -v "%current_dir%:/src" bearer/bearer scan /src/src/main/ --format jsonv2 --output %result_file%
