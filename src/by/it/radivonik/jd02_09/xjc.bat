::SET path_xjc="c:\Program Files\Java\jdk1.8.0_111\bin\xjc.exe"
::SET path_to_src="D:\Java\Kurs\JD2017-02-20\src"
::SET file_xsd="D:\Java\Kurs\JD2017-02-20\src\by\it\radivonik\jd02_09\naklads.xsd"

SET path_xjc="%JDK_HOME%\bin\xjc.exe"
SET path_to_src="..\..\..\..\..\src"
SET file_xsd="%path_to_src%\by\it\radivonik\jd02_09\naklads.xsd"

@echo on
%path_xjc% %file_xsd% -d %path_to_src%