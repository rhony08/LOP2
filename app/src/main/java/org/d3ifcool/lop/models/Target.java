package org.d3ifcool.lop.models;

/**
 * Created by Lisa Krisnawati on 09/03/2018.
 */

public class Target {
    private String id;
    private String name;
    private String desc;

    public Target(String id, String name, String desc){
        this.id =id;
        this.name = name;
        this.desc =desc;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
