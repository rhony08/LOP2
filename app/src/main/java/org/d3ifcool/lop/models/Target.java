package org.d3ifcool.lop.models;

/**
 * Model of Target.
 * Data Target will be use to a recommend activity to user.
 */

public class Target {
    private String id;
    private String name;
    private String desc;

    /**
     * Make an Object of Target.
     * @param id unique data.
     * @param name title of the Target.
     * @param desc description of the Target.
     */
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
