package org.d3ifcool.lop.models;

/**
 * Created by Lisa Krisnawati on 09/03/2018.
 */

public class PersonalityType {
    private String id;
    private String desc;
    private String character;
    private String img;
    private String devTarget;

    public PersonalityType (String id, String desc, String character, String img, String devTarget){
        this.id = id;
        this.desc = desc;
        this.character = character;
        this.img = img;
        this.devTarget = devTarget;
    }

    public String getId() {
        return id;
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
