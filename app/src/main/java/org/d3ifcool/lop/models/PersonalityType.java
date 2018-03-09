package org.d3ifcool.lop.models;

/**
 * Created by Lisa Krisnawati on 09/03/2018.
 */

public class PersonalityType {
    private String mId;
    private String mDesc;
    private String mSifat;
    private String mGambar;
    private String mTargetPengembangan;

    public PersonalityType (String id, String desc, String sifat, String gambar, String targetPengembangan){
        mId = id;
        mDesc = desc;
        mSifat = sifat;
        mGambar = gambar;
        mTargetPengembangan = targetPengembangan;
    }

    public String getmId() {
        return mId;
    }

    public String getmDesc() {
        return mDesc;
    }

    public String getmGambar() {
        return mGambar;
    }

    public String getmSifat() {
        return mSifat;
    }

    public String getmTargetPengembangan() {
        return mTargetPengembangan;
    }
}
