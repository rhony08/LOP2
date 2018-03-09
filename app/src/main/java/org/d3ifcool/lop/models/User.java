package org.d3ifcool.lop.models;

/**
 * Created by Lisa Krisnawati on 09/03/2018.
 */

public class User {
    private String mId;
    private String mNama;
    private String mTempatLahir;
    private int mTanggalLahir;
    private String mIdTipeKepribadian;

    public User(String id, String nama, String tempatLahir, int tanggalLahir, String idTipeKepribadian){
        mId = id;
        mNama = nama;
        mTempatLahir =tempatLahir;
        mTanggalLahir = tanggalLahir;
        mIdTipeKepribadian = idTipeKepribadian;
    }

    public String getmId() {
        return mId;
    }

    public String getmNama() {
        return mNama;
    }

    public String getmTempatLahir() {
        return mTempatLahir;
    }

    public int getmTanggalLahir() {
        return mTanggalLahir;
    }

    public String getmIdTipeKepribadian() {
        return mIdTipeKepribadian;
    }
}
