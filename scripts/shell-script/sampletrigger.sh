#!/bin/bash

# Hadoop Job related metrics collection
# Invoke DataFetcherMain Java program to collect Hadoop Job related metrics
# Truncate Finished Job records to do full load of finished job details

count=$(mysql --silent -h ip-172-31-28-247.ec2.internal -P 3306 -u root -pbdre@1234 -D PlatformMonitor<<<"select count(*) from FinishedInfo")
echo $count | tee -a "t1.out"
if [ $count -gt 0 ]
then
  mysql --silent -h ip-172-31-28-247.ec2.internal -P 3306 -u root -pbdre@1234 -D PlatformMonitor -e "truncate table FinishedInfo"
fi

if [ $? -eq 0 ]
then
 echo "Successfully truncated FinishedInfo details" | tee -a t1.log
else
 echo "Problem in truncating FinishedInfo table" | tee -a tl.log
fi



