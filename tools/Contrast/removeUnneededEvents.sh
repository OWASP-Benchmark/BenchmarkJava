#!/bin/sh
# This script removes ALL the filenames passed to it. It is intended to be used by the prepareContrastResults.sh script to remove all the unnecessary event files in the forcontrast/findings folder.  A script had to be written because simply calling rm APP* didn’t work because the # of parameters to rm was too many.
# The shift function in this loop drops the first parameter and moves all the remaining parameters down one, allowing you to delete one file at a time.
#BE CAREFUL if you use it somewhere else.

while (( "$#" )); do

rm $1

shift

done

