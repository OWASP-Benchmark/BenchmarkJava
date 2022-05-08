#!/usr/bin/ruby
puts "Calculating"
first_number  = ARGV[0]#.to_i
second_number = ARGV[1]#.to_i
print "Args:",first_number,second_number,"
"
print eval(first_number+"+"+second_number)
