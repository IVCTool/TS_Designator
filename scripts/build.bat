@echo off

rem ===============================================================================================================================================================================
rem Define constants
rem ===============================================================================================================================================================================
setlocal
set CURRENTDIR=%~dp0
call %CURRENTDIR%config.bat

rem ===============================================================================================================================================================================
rem Run gradlew
rem ===============================================================================================================================================================================
cd /d %TSBASEDIR%
call gradlew.bat eclipse
call gradlew.bat install
    rem generates %TSDIR%\build\distributions\%TSNAME%-%TSVERSION%.zip
    rem generates %TSBASEDIR%\%TESTAPPNAME%\build\distributions\%TESTAPPNAME%-%TSVERSION%.zip

rem Add RTI jar in .classpath (necessary for running standalone without IVCT GUI, in Eclipse)
%CURRENTDIR%sed.exe -i "s$</classpath>$    <classpathentry kind=\"lib\" path=\"%LRC_CLASSPATH:\=/%\"/>\n</classpath>$g" %TSDIR%\.classpath

rem Unzip test suite and test app to runtime folder
%CURRENTDIR%7za.exe x %TSDIR%\build\distributions\%TSNAME%-%TSVERSION%.zip                        -o%IVCTFOLDER%\runtime -aoa
%CURRENTDIR%7za.exe x %TSBASEDIR%\%TESTAPPNAME%\build\distributions\%TESTAPPNAME%-%TSVERSION%.zip -o%IVCTFOLDER%\runtime -aoa

rem ===============================================================================================================================================================================
rem Copy files from %TSBASEDIR%\IVCT_Runtime to %IVCTFOLDER%\runtime
rem ===============================================================================================================================================================================
xcopy /s /q /y %TSBASEDIR%\IVCT_Runtime %IVCTFOLDER%\runtime
set LOGBACKDIR=%IVCTFOLDER%\runtime\%TSNAME%-%TSVERSION%\lib\lib
mkdir %LOGBACKDIR%
move %IVCTFOLDER%\runtime\logback-test.xml %LOGBACKDIR%\

rem ===============================================================================================================================================================================
rem Build jar
rem ===============================================================================================================================================================================
cd /d %TSBASEDIR%
call gradlew.bat jar

rem ===============================================================================================================================================================================
rem Copy jar files of test suite to runtime folder
rem ===============================================================================================================================================================================
mkdir %IVCTFOLDER%\runtime\TestSuitesDist\%TSNAME%-%TSVERSION%\lib
copy /y %TSDIR%\build\libs\%TSNAME%-%TSVERSION%.jar %IVCTFOLDER%\runtime\TestSuitesDist\%TSNAME%-%TSVERSION%\lib\
copy /y %TSDIR%\src\main\resources\oorti-*.jar %IVCTFOLDER%\runtime\TestSuitesDist\%TSNAME%-%TSVERSION%\lib\

rem ===============================================================================================================================================================================
rem Copy jar files of test app to runtime folder
rem ===============================================================================================================================================================================
mkdir %IVCTFOLDER%\runtime\%TESTAPPNAME%-%TSVERSION%\lib
copy /y %TSBASEDIR%\%TESTAPPNAME%\build\libs\%TESTAPPNAME%-%TSVERSION%.jar %IVCTFOLDER%\runtime\%TESTAPPNAME%-%TSVERSION%\lib\

rem ===============================================================================================================================================================================
rem End
rem ===============================================================================================================================================================================
:END
cd /d %CURRENTDIR%