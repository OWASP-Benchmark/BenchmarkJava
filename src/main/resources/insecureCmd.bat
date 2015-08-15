@echo off
set line=%FOO%

echo Your original string: 
%FOO%
set num=0
:LOOP
call set tmpa=%%line:~%num%,1%%%
set /a num+=1
if not "%tmpa%" equ "" (
set rline=%tmpa%%rline%
goto LOOP
)
echo Your string reversed value is: %rline%