@echo off
javac -d . *.java
if %errorlevel% neq 0 (
    echo Compilation failed.
    pause
    exit /b %errorlevel%
)
java com.mycompany.assignment2.Main
pause
