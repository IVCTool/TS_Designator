@echo off

rem ===============================================================================================================================================================================
rem Define constants
rem ===============================================================================================================================================================================
setlocal
set CURRENTDIR=%~dp0
call %CURRENTDIR%config.bat
set CLONEANDBUILDIVCTDEVELOPMENT=0
set IVCT_FRAMEWORK_ZIPFILE=%CURRENTDIR%IVCT_Framework-development_20200821.zip
set IVCT_TESTSUITEDEVELOPMENT_ZIPFILE=%CURRENTDIR%IVCT_TestSuiteDevelopment-development.zip

rem ===============================================================================================================================================================================
rem Check environment variables; delete directories
rem ===============================================================================================================================================================================
mkdir %IVCTFOLDER% > NUL 2>&1

rem Check environment variables
if /i "%IVCT_CONF%" neq "%IVCTFOLDERWITHSLASHES%/runtime/IVCT.properties" (
    echo WARNING - Please set system environment variable IVCT_CONF to %IVCTFOLDERWITHSLASHES%/runtime/IVCT.properties
    pause
)
if /i "%LRC_CLASSPATH%" neq "C:\Program Files\prti1516e\lib\prti1516.jar" (
    echo WARNING - Please set system environment variable LRC_CLASSPATH to C:\Program Files\prti1516e\lib\prti1516.jar
    pause
)

rem Delete directories
set listOfDirsToBeDeleted=(%IVCTFOLDER%\eclipseWorkspace %IVCTFOLDER%\IVCT_Framework %IVCTFOLDER%\IVCT_TestSuiteDevelopment %IVCTFOLDER%\runtime)
set ATLEASTONEDIRTOBEDELETED=0
for %%x in %listOfDirsToBeDeleted% do if exist %%x set ATLEASTONEDIRTOBEDELETED=1
if "%ATLEASTONEDIRTOBEDELETED%"=="1" (
    echo You should first delete the following directories:
    for %%x in %listOfDirsToBeDeleted% do if exist %%x echo     %%x
    echo For that to succeed, you possibly have to kill process java.exe
    set /p ANSWER="Did you delete the directories? (Y/N) "
    if /i "%ANSWER%" neq "Y" (
        echo ERROR - Directories not deleted
        goto END
    )
)
for %%x in (%USERPROFILE%\.gradle %USERPROFILE%\.m2) do if exist %%x echo You might delete directory %%x

rem ===============================================================================================================================================================================
rem Copy gradle.properties to .gradle folder
rem ===============================================================================================================================================================================
if not exist %USERPROFILE%\.gradle mkdir %USERPROFILE%\.gradle
copy /y gradle.properties %USERPROFILE%\.gradle\

rem ===============================================================================================================================================================================
rem Clone or unzip IVCT_Framework and IVCT_TestSuiteDevelopment
rem ===============================================================================================================================================================================

rem Clone or unzip IVCT_Framework
set DO_UNZIP=1
cd /d %IVCTFOLDER%
if "%DO_UNZIP%"=="1" (
    %CURRENTDIR%7za.exe x %IVCT_FRAMEWORK_ZIPFILE% -o%IVCTFOLDER%
    move IVCT_Framework-development IVCT_Framework
) else (
    git clone -b development https://github.com/IVCTool/IVCT_Framework.git
    cd %IVCTFOLDER%IVCT_Framework
    rem git log > git.log
    rem git checkout bd829acb83b9b8895e6a23a4b1304cfd443bdaec
)

rem Clone or unzip IVCT_TestSuiteDevelopment
set DO_UNZIP=1
if "%CLONEANDBUILDIVCTDEVELOPMENT%"=="1" (
    cd /d %IVCTFOLDER%
    if "%DO_UNZIP%"=="1" (
        %CURRENTDIR%7za.exe x %IVCT_TESTSUITEDEVELOPMENT_ZIPFILE% -o%IVCTFOLDER%
        move IVCT_TestSuiteDevelopment-development IVCT_TestSuiteDevelopment
    ) else (
        git clone -b development https://github.com/IVCTool/IVCT_TestSuiteDevelopment.git
        cd %IVCTFOLDER%IVCT_TestSuiteDevelopment
        rem git log > git.log
        rem git checkout 2f0d58916b526cc6e83823f250802a5766209c00
    )
)

rem ===============================================================================================================================================================================
rem Build IVCT_Framework and IVCT_TestSuiteDevelopment
rem ===============================================================================================================================================================================

rem Create folder for Eclipse workspace
mkdir %IVCTFOLDER%\eclipseWorkspace > NUL 2>&1

rem Build IVCT_Framework
cd /d %IVCTFOLDER%\IVCT_Framework
call gradlew.bat eclipse
call gradlew.bat install
    rem loads some dependencies, like IEEE etc
call gradlew.bat installDist
    rem generates %IVCTFOLDER%\IVCT_Framework\Command\build\libs\Command-x.x.x.jar
    rem generates %IVCTFOLDER%\IVCT_Framework\Command\src\main\resources\dev.properties

rem Add reference to prti1516e.jar to .classpath
rem The interactive way to do this would be:
rem     TC.exec - rightclick - properties - Java build path - libraries - add external jars - add C:\Program Files\prti1516e\lib\prti1516e.jar (otherwise later error "unable to create RTI ambassador")
%CURRENTDIR%sed.exe -i "s$</classpath>$    <classpathentry kind=\"lib\" path=\"%LRC_CLASSPATH:\=/%\"/>\n</classpath>$g" %IVCTFOLDER%\IVCT_Framework\TC.exec\.classpath

rem Build IVCT_TestSuiteDevelopment
if "%CLONEANDBUILDIVCTDEVELOPMENT%"=="1" (
    cd /d %IVCTFOLDER%\IVCT_TestSuiteDevelopment
    call gradlew.bat eclipse
    call gradlew.bat distzip
        rem generates %IVCTFOLDER%\IVCT_TestSuiteDevelopment\HelloWorld\build\distributions\HelloWorld-2.1.1.zip
)

rem ===============================================================================================================================================================================
rem Prepare runtime folder
rem ===============================================================================================================================================================================
xcopy /s /y %IVCTFOLDER%\IVCT_Framework\RuntimeConfig %IVCTFOLDER%\runtime\

rem Update IVCT.properties
%CURRENTDIR%sed.exe -r -i "s$#[[:space:]]*IVCT_SUT_HOME_ID=.*$IVCT_SUT_HOME_ID=%IVCTFOLDERWITHSLASHES%/runtime/IVCTsut$g"                      %IVCTFOLDER%\runtime\IVCT.properties
%CURRENTDIR%sed.exe -r -i "s$#[[:space:]]*IVCT_TS_HOME_ID[[:space:]]*=.*$IVCT_TS_HOME_ID=%IVCTFOLDERWITHSLASHES%/runtime/TestSuitesDist$g"     %IVCTFOLDER%\runtime\IVCT.properties
%CURRENTDIR%sed.exe -r -i "s$#[[:space:]]*IVCT_TS_DEF_HOME_ID[[:space:]]*=.*$IVCT_TS_DEF_HOME_ID=%IVCTFOLDERWITHSLASHES%/runtime/TestSuites$g" %IVCTFOLDER%\runtime\IVCT.properties
%CURRENTDIR%sed.exe -r -i "s$#[[:space:]]*IVCT_BADGE_HOME_ID[[:space:]]*=.*$IVCT_BADGE_HOME_ID=%IVCTFOLDERWITHSLASHES%/runtime/Badges$g"       %IVCTFOLDER%\runtime\IVCT.properties
%CURRENTDIR%sed.exe -r -i "s$#[[:space:]]*IVCT_BADGE_ICONS[[:space:]]*=.*$IVCT_BADGE_ICONS=%IVCTFOLDERWITHSLASHES%/runtime/Badges$g"           %IVCTFOLDER%\runtime\IVCT.properties
%CURRENTDIR%sed.exe -r -i "s$#[[:space:]]*ACTIVEMQ_PASSWORD[[:space:]]*=.*$ACTIVEMQ_PASSWORD=admin$g"                                          %IVCTFOLDER%\runtime\IVCT.properties

%CURRENTDIR%sed.exe -i "s$\"settingsDesignator\": \"\",$\"settingsDesignator\": \"crcAddress=localhost:8989\",$g" %IVCTFOLDER%\runtime\IVCTsut\hw_iosb\CS.json
%CURRENTDIR%sed.exe -r -i "s/(\"version\": \".*\"$)/\1,/g"                                                        %IVCTFOLDER%\runtime\IVCTsut\hw_iosb\CS.json

if "%CLONEANDBUILDIVCTDEVELOPMENT%"=="1" (
    mkdir %IVCTFOLDER%\runtime\TestSuitesDist\TS_HelloWorld-2.1.1\lib
    copy /y %IVCTFOLDER%\IVCT_TestSuiteDevelopment\TS_HelloWorld\build\libs\TS_HelloWorld-2.1.1.jar %IVCTFOLDER%\runtime\TestSuitesDist\TS_HelloWorld-2.1.1\lib\
    %CURRENTDIR%7za.exe x %IVCTFOLDER%\IVCT_TestSuiteDevelopment\HelloWorld\build\distributions\HelloWorld-2.1.1.zip -o%IVCTFOLDER%\runtime
)

rem ===============================================================================================================================================================================
rem END
rem ===============================================================================================================================================================================
:END
cd /d %CURRENTDIR%