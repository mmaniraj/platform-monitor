package com.wipro.analytics.beans;

import com.wipro.analytics.fetchers.DataFetcherMain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by cloudera on 3/19/17.
 */
@Entity
@Table(name="QueueInfo")
public class QueueInfo implements Serializable {
    @Id
    @GeneratedValue(strategy=IDENTITY)
    @Column
    private int id;
    @Column
    private String queueName;
    @Column
    private double absoluteAllocatedCapacity;
    @Column
    private double absoluteUsedCapacity;
    @Column
    private int usedMemory;
    @Column
    private int usedCores;
    @Column
    private int numContainers;
    @Column
    private String queueState;
    @Column
    private int maxApplications;
    @Column
    private int numApplications;
    @Column
    private int numActiveApplications;
    @Column
    private int numPendingApplications;
    @Column
    private String queueType;
    @Column
    private String users;
    @Column
    private Timestamp timestamp;

    public int getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(int usedMemory) {
        this.usedMemory = usedMemory;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }


    public double getAbsoluteUsedCapacity() {
        return absoluteUsedCapacity;
    }

    public void setAbsoluteUsedCapacity(double absoluteUsedCapacity) {
        this.absoluteUsedCapacity = absoluteUsedCapacity;
    }

    public double getAbsoluteAllocatedCapacity() {
        return absoluteAllocatedCapacity;
    }

    public void setAbsoluteAllocatedCapacity(double absoluteAllocatedCapacity) {
        this.absoluteAllocatedCapacity = absoluteAllocatedCapacity;
    }

    public int getUsedCores() {
        return usedCores;
    }

    public void setUsedCores(int usedCores) {
        this.usedCores = usedCores;
    }

    public int getNumContainers() {
        return numContainers;
    }

    public void setNumContainers(int numContainers) {
        this.numContainers = numContainers;
    }

    public String getQueueState() {
        return queueState;
    }

    public void setQueueState(String queueState) {
        this.queueState = queueState;
    }

    public int getMaxApplications() {
        return maxApplications;
    }

    public void setMaxApplications(int maxApplications) {
        this.maxApplications = maxApplications;
    }

    public int getNumApplications() {
        return numApplications;
    }

    public void setNumApplications(int numApplications) {
        this.numApplications = numApplications;
    }

    public int getNumActiveApplications() {
        return numActiveApplications;
    }

    public void setNumActiveApplications(int numActiveApplications) {
        this.numActiveApplications = numActiveApplications;
    }

    public int getNumPendingApplications() {
        return numPendingApplications;
    }

    public void setNumPendingApplications(int numPendingApplications) {
        this.numPendingApplications = numPendingApplications;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }


    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        String fieldDelimiter= DataFetcherMain.FILE_FIELD_SEPERATOR;
        return
                queueName+ fieldDelimiter
                + absoluteAllocatedCapacity+ fieldDelimiter
                + absoluteUsedCapacity+ fieldDelimiter
                + usedMemory+ fieldDelimiter
                + usedCores+ fieldDelimiter
                + numContainers+ fieldDelimiter
                + queueState+ fieldDelimiter
                + maxApplications+ fieldDelimiter
                + numApplications+ fieldDelimiter
                + numActiveApplications+ fieldDelimiter
                + numPendingApplications+ fieldDelimiter
                + queueType+ fieldDelimiter
                + users+ fieldDelimiter
                + timestamp;
    }

}
