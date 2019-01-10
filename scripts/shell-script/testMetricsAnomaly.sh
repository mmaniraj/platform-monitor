#!/bin/bash

today=$(date +%Y-%m-%d)
currentTime=$(date +%Y-%m-%d-%H-%M-%S)

function checkAnomaly()
{
  metricNames=$1
  metricValues=$2
  host=$3
  #echo $1 $2 $3
  
  count=$(mysql --silent -h localhost -P 3306 -u root -p wipro@123 -D PlatformMonitor<<<"select count(*) as return_code from MetricsAnomalyRange2 where $2 between lowerlimit and upperlimit AND metricsName='$1' AND host='$3'")
 
 if [ $count -eq 0 ]
 then
     #echo "Metrics is Within Range : "$1 |& tee -a log_$today.txt
      echo "Anomaly Detected at "$currentTime " for the metrics : "$1" with value :  "$2" in the host : "$3 |& tee -a anomalyResult_$today.txt
 fi
}

checkAnomaly "cpu_user" $2 $1
checkAnomaly "cpu_system" $3 $1
checkAnomaly "cpu_idle" $4 $1
checkAnomaly "mem_free" $5 $1
checkAnomaly "mem_total" $6 $1
checkAnomaly "mem_cached" $7 $1

# Mail Notification if anomaly is detected
file="/home/openbdre/platform-monitor/scripts/shell-script/anomalyResult_"$today".txt"

if [ ! -f "/home/openbdre/platform-monitor/scripts/shell-script/mailTrigger.txt" ]
then
  echo $(date +%s) > mailTrigger.txt
fi

if [ -f "/home/openbdre/platform-monitor/scripts/shell-script/anomalyResult_"$today".txt" ] 
then
    #echo "File exists" > debugmail.txt
    if [  $(( $(date +%s) - $(head -n 1 mailTrigger.txt) )) -gt 120 ]
    then
       # trigger email
       #echo "trigger mail" > debugmail.txt
       echo $(date +%s) > mailTrigger.txt
       echo "!!! Platform Monitoring Alert !!!" | mail -s "Anomaly Detected" -a anomalyResult_$today.txt mani.murugan@wipro.com
       mv anomalyResult_$today.txt ./archive_anomaly/
    fi 
else
    echo "No Anomaly Detected"
fi	
