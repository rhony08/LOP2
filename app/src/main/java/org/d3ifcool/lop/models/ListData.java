package org.d3ifcool.lop.models;

/**
 * Created by CHEVALIER-11 on 12-Mar-18.
 */

public class ListData {
    private int id;
    private String name;
    private String description;

    /**
     * Make an Object of List.
     * @param id unique data.
     * @param name title of the List.
     * @param description description of the List.
     */
    public ListData(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public ListData(String name, String description){
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }
}
