import urllib, json
import numpy as np
import mysql.connector

def compute_boundary_limit(metricsValArray,metric):
  #print("inside function")
  print "mean",np.mean(metricsValArray)
  print "sd",np.std(metricsValArray) 
  lbound = np.mean(metricsValArray) - (2 * (np.std(metricsValArray)))
  ubound = np.mean(metricsValArray) + (2 * (np.std(metricsValArray)))
  #print metric
  lbound = float(lbound)
  ubound = float(ubound)
  #print "type of lbound",type(lbound)
  print "lbound : ",lbound,"ubound : ",ubound
  #print ubound
  return lbound,ubound
  
def submitDetailstoDB(metric,host,lbound,ubound): 
	print "mysql connect for :",metric
	mydb = mysql.connector.connect(
		host="10.201.45.15",
		user="root",
		passwd="wipro@123",
		database="PlatformMonitor"
	)
	mycursor = mydb.cursor()
	#mycursor.execute("SHOW DATABASES")
	#for x in mycursor:
	#  print(x)
	# CREATE TABLE MetricsAnomalyRange (metricsName VARCHAR(100), host VARCHAR(100), lowerLimit DOUBLE, upperLimit DOUBLE, createdTime timestamp DEFAULT CURRENT_TIMESTAMP )
	sql = "INSERT INTO MetricsAnomalyRange (metricsName, host, lowerLimit, upperLimit) VALUES (%s, %s, %s, %s)"
	mycursor.execute(sql, (metric,host,lbound,ubound))
	mydb.commit()
	print(mycursor.rowcount, "record inserted.")
	
def archiveToHistory(): 
	print "mysql connect for archiving"
	mydb = mysql.connector.connect(
		host="10.201.45.15",
		user="root",
		passwd="wipro@123",
		database="PlatformMonitor"
	)
	mycursor = mydb.cursor()
	#mycursor.execute("SHOW DATABASES")
	#for x in mycursor:
	#  print(x)
	# CREATE TABLE MetricsAnomalyRangeHistory (metricsName VARCHAR(100), host VARCHAR(100), lowerLimit VARCHAR(100), upperLimit VARCHAR(100), createdTime timestamp DEFAULT CURRENT_TIMESTAMP )
	sql = "SELECT count(*) FROM MetricsAnomalyRange"
        mycursor.execute(sql)
	result = mycursor.fetchone()
	no_of_rows = result[0]
	print no_of_rows

        if no_of_rows > 0 :
           print "mysql connect insert to history"
	   mycursor = mydb.cursor()
	   sql = "INSERT INTO MetricsAnomalyRangeHistory SELECT * from MetricsAnomalyRange"
	   mycursor.execute(sql)
	   mydb.commit()
	   print(mycursor.rowcount, "record inserted.")
           print "truncate table"
           mycursor = mydb.cursor()
           sql = "TRUNCATE TABLE MetricsAnomalyRange"
           mycursor.execute(sql)
           mydb.commit()
        	
	
	

archiveToHistory()
file=open("/home/openbdre/platform-monitor/scripts/python-script/opentsdb/queryUrl.txt","r")
url=file.read()
response = urllib.urlopen(url)
data = json.loads(response.read())
metricsCnt = len(data)
i=0
while i < metricsCnt :
 datapoints = data[i]['dps']
 metric = data[i]['metric']
 hostname = data[i]['tags']['host']
 metricsValArray = datapoints.values()
 print hostname,metric
 #print metric
 print metricsValArray
 #Anomaly boundary computation
 lbound,ubound = compute_boundary_limit(metricsValArray,metric)
 #DB insertion
 submitDetailstoDB(metric,hostname,lbound,ubound)
 i+=1
 
 

 
