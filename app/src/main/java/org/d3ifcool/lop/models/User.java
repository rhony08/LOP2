package org.d3ifcool.lop.models;

/**
 * Created by Lisa Krisnawati on 09/03/2018.
 */

public class User {
    private String id;
    private String name;
    private String birthPlace;
    private int birthDate;
    private String idPersonality;

    public User(String id, String name, String birthPlace, int birthDate, String idPersonality){
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
        this.idPersonality = idPersonality;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public String getIdPersonality() {
        return idPersonality;
    }
}
