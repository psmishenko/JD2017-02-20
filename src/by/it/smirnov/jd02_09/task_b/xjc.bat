set path_xjc="C:\Program Files\Java\jdk1.8.0_121\bin\xjc.exe"
set path_to_src="C:\Users\aleksey.smirnov\IdeaProjects\JD2017-02-20\src"
set file_xsd="C:\Users\aleksey.smirnov\IdeaProjects\JD2017-02-20\src\by\it\smirnov\jd02_09\task_b\BankLimits.xsd"

@echo on
%path_xjc% %file_xsd% -d %path_to_src%