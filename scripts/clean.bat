@echo off

rem ===============================================================================================================================================================================
rem Define constants
rem ===============================================================================================================================================================================
setlocal
set CURRENTDIR=%~dp0
call %CURRENTDIR%config.bat

rem ===============================================================================================================================================================================
rem Clean up
rem ===============================================================================================================================================================================
cd /d %TSBASEDIR%
call gradlew.bat clean
call gradlew.bat cleanEclipse

taskkill /f /im java.exe

for %%x in (%TSBASEDIR%\.gradle
            %TSBASEDIR%\docs\.settings
            %TSBASEDIR%\%TESTAPPNAME%\.settings
            %TSBASEDIR%\%TESTAPPNAME%\bin
            %TSDIR%\.settings
            %TSDIR%\bin
            %IVCTFOLDER%\runtime\%TESTAPPNAME%-%TSVERSION%
            %IVCTFOLDER%\runtime\TestSuitesDist\%TSNAME%-%TSVERSION%) do (
    if exist %%x rmdir /s /q %%x
)

for %%x in (%TSBASEDIR%\.project
            %TSBASEDIR%\*.lock
            %TSBASEDIR%\.classpath
            %TSBASEDIR%\.bin
            %TSDIR%\src\main\resources\testCaseBuild.properties) do (
    del /s /q %%x
)

rem ===============================================================================================================================================================================
rem End
rem ===============================================================================================================================================================================
:END
cd /d %CURRENTDIR%