FOR %%I In (*.txt) DO (
"C:\Program Files\Java\jdk1.8.0_121\bin\native2ascii.exe" -encoding utf-8 %%I %%~nI.properties
)