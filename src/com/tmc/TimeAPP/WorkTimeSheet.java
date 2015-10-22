package com.tmc.TimeAPP;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDE
 * User : vidit
 * Date : 12/11/14.
 * Time : 9:12 PM
 */
public class WorkTimeSheet {

    private ArrayList<WorkTimeUnit> mdata = new ArrayList<WorkTimeUnit>();

    WorkTimeSheet(ArrayList<WorkTimeUnit> listdata){
        mdata = listdata;
    }

    public ArrayList<WorkTimeUnit> getList(){
        return mdata;
    }

    public void setList(ArrayList<WorkTimeUnit> listdata){

        mdata = listdata;
    }
}
