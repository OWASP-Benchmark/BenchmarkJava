benchmark_version=$(scripts/getBenchmarkVersion.sh)
FortifySCA_version=$(sourceanalyzer -v | grep 'Fortify Static' | cut -d" " -f5)
FortifyRulePack_version=$(fortifyupdate -showInstalledRules | grep "Core, Java v" | cut -d" " -f7)

results_file="results/Benchmark_${benchmark_version}-Fortify${FortifySCA_version}_${FortifyRulePack_version}.fpr"

sourceanalyzer -b benchmark -Xmx10G -scan -f $results_file
echo "Results written to: $results_file"

