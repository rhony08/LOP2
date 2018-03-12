package org.d3ifcool.lop.models;

/**
 * User model.
 * This data will use to system decide some targets & tips.
 */

public class User {
    private String id;
    private String name;
    private String birthPlace;
    private int birthDate;
    private String idPersonality;

    /**
     * Create an Object of User
     * @param id unique data
     * @param name name of user
     * @param birthPlace cityName of user's birthPlace
     * @param birthDate date when user birth
     */
    public User(String id, String name, String birthPlace, int birthDate){
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.birthDate = birthDate;
    }

    public void setIdPersonality(String idPersonality) {
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
