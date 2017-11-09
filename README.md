# FolderDeleter

This simple software is used as server side service. 

The use case is a situation like this:
I have more backup folder named by the day of bakcup job (like mm.dd.yyyy)
I want to delete folder older than x days.
So this is the purpose of this software, delete all the backup folder older than x days.

The usage is like a terminal command and the sintax is:
java -jar FolderDeleter.jar -p /home/to/path/desired -d number_od_days_older_check
where:
-p is the argument passed for path to analize
-d is the days passed to make comparison.

Next to compile and making of the *.jar file.
