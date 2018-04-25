package org.d3ifcool.lop.models;

import org.d3ifcool.lop.R;

/**
 * Model of Data.
 * Data Data will be use to a recommend activity to user.
 */

public class Data extends ListData {
    final int COMPLETED = R.drawable.ic_check_circle_24dp;
    final int ONPROGRESS = R.drawable.ic_directions_bike_24dp;
    final int FAILED = R.drawable.ic_cancel_24dp;
    final int LOCKED = -1;
    private int status;

    /**
     * Make an Object of Data.
     * @param id unique data.
     * @param name title of the Data.
     * @param desc description of the Data.
     * @param status ONPROGRESS, COMPLETED, FAILED
     */
    public Data(String id, String name, String desc, int status){
        super(id, name, desc);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public int getImage(){
        if (status == 0) return FAILED;
        else if (status == 1) return COMPLETED;
        else if (status == 2) return ONPROGRESS;
        else return LOCKED;
    }
}
