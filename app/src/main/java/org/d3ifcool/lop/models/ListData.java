package org.d3ifcool.lop.models;

/**
 * Created by CHEVALIER-11 on 12-Mar-18.
 */

public class ListData {
    private String id;
    private String name;
    private String desc;

    /**
     * Make an Object of List.
     * @param id unique data.
     * @param name title of the List.
     * @param desc description of the List.
     */
    public ListData(String id, String name, String desc){
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
