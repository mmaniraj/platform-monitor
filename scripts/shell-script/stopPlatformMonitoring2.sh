#!/bin/bash

LOG_DIR="/home/openbdre/platform-monitor/log"
rm -rf $LOG_DIR/stop.out

# kill hadoop monitor java process
for PID in `ps -eaf | grep hadoopmonitor | grep -v grep | awk '{print $2}'`
do
   echo  "killing hadoopmonitor java process" | tee -a $LOG_DIR/stop.out
   sudo kill -9 $PID
done

sleep 5

# stop nifi service
sudo service nifi stop
NIFI_PROCESS_CHECK=$(ps -aux | grep nifi | grep -v grep | wc -l)
if [ $NIFI_PROCESS_CHECK -eq 0 ]
then
   echo "Nifi service is STOPPED !!!" | tee -a $LOG_DIR/stop.out
else
   echo "Problem in stopping Nifi service" | tee -a $LOG_DIR/stop.out
fi

sleep 15

# kill opentsdb process
for PID2 in `ps -eaf | grep opentsdb | grep -v grep | awk '{print $2}'`
do
   echo  "killing opentsdb process" | tee -a $LOG_DIR/stop.out
   sudo kill -9 $PID2
done

sleep 15

echo "Platform Monitoring is successfully SHUT DOWN !!!" | tee -a $LOG_DIR/stop.out
