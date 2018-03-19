package org.d3ifcool.lop.models;

/**
 * Model of Human character.
 */

public class Character extends ListData{
    public Character(String id, String nama, String desc){
        super(id, nama, desc);
    }

    @Override
    public String toString() {
        return getName().toUpperCase() +
                "\n" + getDesc();
    }
}
