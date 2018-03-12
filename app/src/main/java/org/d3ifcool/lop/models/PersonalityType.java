package org.d3ifcool.lop.models;

/**
 * Model of Personality Type, like INTP, ISTP, etc.
 */

public class PersonalityType {
    private String id;
    private String name;
    private String desc;
    private String character;
    private String img;
    private String devTarget;

    /**
     * Make an Object of Personality Type.
     * @param id unique data
     * @param name unique data
     * @param desc description of this type
     * @param character ID of Character
     * @param img Name/path/link image
     * @param devTarget ID Target
     */
    public PersonalityType (String id, String name, String desc, String character, String img, String devTarget){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.character = character;
        this.img = img;
        this.devTarget = devTarget;
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

    public String getImg() {
        return img;
    }

    public String getCharacter() {
        return character;
    }

    public String getDevTarget() {
        return devTarget;
    }
}
