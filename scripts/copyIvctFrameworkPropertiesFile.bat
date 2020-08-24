@echo off
setlocal
set CURRENTDIR=%~dp0
call %CURRENTDIR%config.bat

if not exist %IVCTFOLDER%\IVCT_Framework\Command\bin\main mkdir %IVCTFOLDER%\IVCT_Framework\Command\bin\main
copy /y %IVCTFOLDER%\IVCT_Framework\Command\src\main\resources\dev.properties %IVCTFOLDER%\IVCT_Framework\Command\bin\main\