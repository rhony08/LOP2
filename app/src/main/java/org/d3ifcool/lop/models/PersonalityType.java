package org.d3ifcool.lop.models;

/**
 * Model of Personality Type, like INTP, ISTP, etc.
 */

public class PersonalityType {
    private String id;
    private String name;
    private String description;
    private Character character;
    private String image;

    /**
     * Make an Object of Personality Type.
     * @param id unique data
     * @param name unique data
     * @param description description of this type
     * @param character Character of Personality
     * @param image Name/path/link image
     */
    public PersonalityType (String id, String name, String description, Character character, String image){
        this.id = id;
        this.name = name;
        this.description = description;
        this.character = character;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return description;
    }

    public String getImg() {
        return image;
    }

    public Character getCharacter() {
        return character;
    }

}
