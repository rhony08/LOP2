package org.d3ifcool.lop.models;

/**
 * Model of Tips.
 * Data Tips will be use to show some advices to user.
 */

public class Tips {
    private String id;
    private String name;
    private String desc;

    /**
     * Make an Object of Tips.
     * @param id unique data.
     * @param name title of the Target.
     * @param desc description of the Target.
     */
    public Tips(String id, String name, String desc){
        this.id = id;
        this.name = name;
        this.desc = desc;
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
