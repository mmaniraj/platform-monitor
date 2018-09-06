package com.wipro.analytics.beans;

import com.wipro.analytics.fetchers.DataFetcherMain;

import javax.persistence.*;
import java.sql.Timestamp;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by cloudera on 4/8/17.
 */
@Entity
@Table(name="HDFSQuotaInfo")
public class HDFSQuotaInfo2 {
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column
    private int id;
    @Column
    private String parentDir;
    @Column
    private String subDir;
    @Column
    private long parentNameQuota;
    @Column
    private long parentDirNumFiles;
    @Column
    private long subdirNumfiles;
    @Column
    private double parentSpaceQuota;
    @Column
    private double parentDirSize;
    @Column
    private double subdirSize;
    @Column
    private Timestamp timestamp;


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getParentDir() {
        return parentDir;
    }

    public void setParentDir(String parentDir) {
        this.parentDir = parentDir;
    }

    public String getSubDir() {
        return subDir;
    }

    public void setSubDir(String subDir) {
        this.subDir = subDir;
    }

    public long getParentNameQuota() {
        return parentNameQuota;
    }

    public void setParentNameQuota(long parentNameQuota) {
        this.parentNameQuota = parentNameQuota;
    }

    public long getParentDirNumFiles() {
        return parentDirNumFiles;
    }

    public void setParentDirNumFiles(long parentDirNumFiles) {
        this.parentDirNumFiles = parentDirNumFiles;
    }

    public long getSubdirNumfiles() {
        return subdirNumfiles;
    }

    public void setSubdirNumfiles(long subdirNumfiles) {
        this.subdirNumfiles = subdirNumfiles;
    }

    public double getParentSpaceQuota() {
        return parentSpaceQuota;
    }

    public void setParentSpaceQuota(double parentSpaceQuota) {
        this.parentSpaceQuota = parentSpaceQuota;
    }

    public double getParentDirSize() {
        return parentDirSize;
    }

    public void setParentDirSize(double parentDirSize) {
        this.parentDirSize = parentDirSize;
    }

    public double getSubdirSize() {
        return subdirSize;
    }

    public void setSubdirSize(double subdirSize) {
        this.subdirSize = subdirSize;
    }

    @Override
    public String toString(){
        String fieldDelimiter= DataFetcherMain.FILE_FIELD_SEPERATOR;

        return    parentDir + fieldDelimiter
                + subDir + fieldDelimiter
                + parentNameQuota + fieldDelimiter
                + parentDirNumFiles + fieldDelimiter
                + subdirNumfiles + fieldDelimiter
                + parentSpaceQuota + fieldDelimiter
                + parentDirSize+ fieldDelimiter
                + subdirSize+ fieldDelimiter
                + timestamp;

    }

}
