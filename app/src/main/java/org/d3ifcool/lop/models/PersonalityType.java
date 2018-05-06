package org.d3ifcool.lop.models;

import java.io.Serializable;

/**
 * Model of Personality Type, like INTP, ISTP, etc.
 */

public class PersonalityType implements Serializable{
    private String id;
    private String name;
    private String type;
    private String description;
    private Character character;
    private String[] characters;
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

    public PersonalityType(String id, String name, String type, String description, String[] characters) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.characters = characters;
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

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

}
