package org.d3ifcool.lop.models;

/**
 * Model of Tips.
 * Data Tips will be use to show some advices to user.
 */

public class Tips  extends Data{
    /**
     * Make an Object of Tips.
     * @param id unique data.
     * @param name title of the Data.
     * @param description description of the Data.
     */
    public Tips(String id, String name, String description) {
        super(id, name, description, -1);
    }

    @Override
    public int getImage() {
        return 0;
    }
}
