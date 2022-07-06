package com.dlazarenko;

public class CallLog {

    public String phoneNumber;
    public long timestamp;
    public long duration;
    public Status status;

    public CallLog(String phoneNumber, long timestamp, long duration, Status status) {
        this.phoneNumber = phoneNumber;
        this.timestamp = timestamp;
        this.duration = duration;
        this.status = status;
    }

    public enum Status {
        Incoming,
        Outgoing,
        Missed,
    }

}
