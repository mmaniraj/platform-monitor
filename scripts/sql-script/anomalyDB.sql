CREATE DATABASE PlatformMonitor
/
CREATE TABLE MetricsAnomalyRange (metricsName VARCHAR(100), host VARCHAR(100),  lowerLimit DOUBLE, upperLimit DOUBLE, createdTime timestamp DEFAULT CURRENT_TIMESTAMP )
/
CREATE TABLE MetricsAnomalyRangeHistory (metricsName VARCHAR(100), host VARCHAR(100), lowerLimit DOUBLE, upperLimit DOUBLE, createdTime timestamp DEFAULT CURRENT_TIMESTAMP )
/
