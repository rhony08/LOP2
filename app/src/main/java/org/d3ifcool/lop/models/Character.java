package org.d3ifcool.lop.models;

/**
 * Created by Lisa Krisnawati on 09/03/2018.
 */

public class Character {
    private String id;
    private String nama;
    private String desc;

    public Character(String id, String nama, String desc){
        this.id = id;
        this.nama = nama;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getDesc() {
        return desc;
    }
}
