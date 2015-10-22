package com.tmc.TimeAPP;

/*
    Header Information:

    *******************************************************************
    DESCRIPTION:
    Singleton unit to store information about check-in and checkout time
    for a given work day

    Note:
        CheckOutTime - CheckInTime < Threshold = 11 hours

 */

public class WorkTimeUnit {

    /*
        Some private data type for this function
     */
    private long checkInTime;
    private long checkOutTime;
    private long maxWorkTime = 11*60*60*1000;  // Note this is long it won't take in any fractional values

    WorkTimeUnit(long checkIn){
        checkInTime = checkIn;
    }

    /*
        method to set check in time
     */
    public void setCheckInTime(long checkIn){
        checkInTime = checkIn;
    }

    /*
        method to set check out time
     */
    public void setCheckOutTime(long checkOut){
        checkOutTime = checkOut;
    }

    /*
        method to get check in time
     */
    public long getCheckInTime(){
        return checkInTime;
    }

    /*
        method to get check out time
     */
    public long getCheckOutTime(){
        return  checkOutTime;
    }

    /*
        method to check if work time is less than the given threshold.
        In case work time is more than threshold then return false and set
        checkOutTime = CheckinTime+Threshold
     */
    private boolean checkworkTime(){
        if(checkOutTime-checkInTime<=maxWorkTime){
            return true;
        }else{
            checkOutTime = checkInTime + maxWorkTime;
            return false;
        }
    }
}
