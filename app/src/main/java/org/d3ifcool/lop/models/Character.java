package org.d3ifcool.lop.models;

/**
 * Created by Lisa Krisnawati on 09/03/2018.
 */

public class Character {
    private String mId;
    private String mNama;
    private String mDesc;

    public Character(String id, String nama, String desc){
        mId =id;
        mNama = nama;
        mDesc =desc;
    }

    public String getmId() {
        return mId;
    }

    public String getmNama() {
        return mNama;
    }

    public String getmDesc() {
        return mDesc;
    }
}
