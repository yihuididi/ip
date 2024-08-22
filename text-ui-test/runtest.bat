@ECHO OFF

REM create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM create data directory if it doesn't exist
if not exist .\data mkdir .\data

REM delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM delete data from previous run
if exist .\data\task.txt del .\data\task.txt

REM compile the code into the bin folder
javac  -cp ..\src\main\java -Xlint:none -d ..\bin ..\src\main\java\task\*.java ..\src\main\java\exception\*.java  ..\src\main\java\executable\*.java ..\src\main\java\*.java
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)
REM no error here, errorlevel == 0

REM run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ..\bin YihuiBot < input.txt > ACTUAL.TXT

REM compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT
