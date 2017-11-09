# FolderDeleter

This simple software is used as server side service. 
<br />
# Description
<br />
The use case is a situation like this:<br />
I have more backup folder named by the day of bakcup job (like mm.dd.yyyy)<br />
I want to delete folder older than x days.<br />
So this is the purpose of this software, delete all the backup folder older than x days.<br />

# Usage
<br />
The usage is like a terminal command and the sintax is:<br />
java -jar FolderDeleter.jar -p /home/to/path/desired -d number_od_days_older_check<br />
where:<br />
-p is the argument passed for path to analize<br />
-d is the days passed to make comparison.<br />
<br />
Next to compile and making of the *.jar file.<br />
