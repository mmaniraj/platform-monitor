#!/bin/bash
#Hadoop Job related metrics collection
#Invoke DataFetcherMain Java program to collect Job metrics
#Truncate FinishedInfo table to avoid primary key violation due to Full load of data from JobHistory server

LOG_DIR="/home/openbdre/platform-monitor/log"
rm -rf $LOG_DIR/trigger.out

GRAFANA_SERVICE_CHECK=$(ps -aux | grep grafana-server | grep -v grep | wc -l)
echo $GRAFANA_SERVICE_CHECK | tee -a $LOG_DIR/trigger.out

if [ $GRAFANA_SERVICE_CHECK -eq 0 ]
then
   sudo service grafana-server start
fi

HADOOP_MONITOR_PGM_CHECK=$(ps -aux | grep hadoopmonitor.jar | grep -v grep | wc -l)
echo $HADOOP_MONITOR_PGM_CHECK | tee -a $LOG_DIR/trigger.out

if [ $HADOOP_MONITOR_PGM_CHECK -eq 0 ]
then
    #mysql --silent -h ip-172-31-28-247.ec2.internal -u root -P 3306 -pbdre@1234 -D PlatformMonitor -e "truncate table FinishedInfo"
    cd /home/openbdre/platform-monitor/HadoopMonitoring
    rm -rf nohup.out
    #nohup java -cp target/hadoopmonitor-1.0-SNAPSHOT.jar com.wipro.analytics.fetchers.DataFetcherMain &
    nohup java -jar target/hadoopmonitor.jar &
    #HADOOP_MONITOR_PGM_CHECK=$(ps -aux | grep hadoopmonitor-1.0-SNAPSHOT.jar | grep -v grep | wc -l)
    HADOOP_MONITOR_PGM_CHECK=$(ps -aux | grep hadoopmonitor.jar | grep -v grep | wc -l)
    if [ $HADOOP_MONITOR_PGM_CHECK -ne 0 ] 
    then
       echo "Hadoop Monitor Java Program is STARTING  !!!" | tee -a $LOG_DIR/trigger.out
    fi
else
    echo "Java Program is already RUNNING !!!" | tee -a $LOG_DIR/trigger.out
fi

NIFI_PROCESS_CHECK=$(ps -aux | grep nifi | grep -v grep | wc -l)
echo $NIFI_PROCESS_CHECK | tee -a $LOG_DIR/trigger.out

if [ $NIFI_PROCESS_CHECK -eq 0 ]
then
    sudo service nifi start
    NIFI_PROCESS_CHECK=$(ps -aux | grep nifi | grep -v grep | wc -l)
    if [ $NIFI_PROCESS_CHECK -ne 0 ]
    then
       echo "Nifi service is STARTING !!!" | tee -a $LOG_DIR/trigger.out
    fi
else
   echo "Nifi service is already RUNNING !!!" | tee -a $LOG_DIR/trigger.out
fi

OPENTSDB_PROCESS_CHECK=$(ps -aux | grep opentsdb | grep -v grep | wc -l)
echo $OPENTSDB_PROCESS_CHECK | tee -a $LOG_DIR/trigger.out

if [ $OPENTSDB_PROCESS_CHECK -eq 0 ]
then
    #echo "OpenTSDB Process is NOT RUNNING !!!" | tee -a $LOG_DIR/trigger.out
    cd /home/openbdre/opentsdb
    rm -rf nohup.out
    nohup  sudo ./build/tsdb tsd --config ./src/opentsdb.conf &
    OPENTSDB_PROCESS_CHECK=$(ps -aux | grep opentsdb | grep -v grep | wc -l)
    if [ $OPENTSDB_PROCESS_CHECK -ne 0 ]
    then
       echo "OpenTSDB Process is STARTING !!!" | tee -a $LOG_DIR/trigger.out
    fi
else
   echo "OpenTSDB Process is already RUNNING !!!" | tee -a $LOG_DIR/trigger.out
fi
