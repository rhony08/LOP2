package org.d3ifcool.lop.models;

/**
 * Model of Personality Question.
 */

public class PersonalityQuestion {
    private String firstOption;
    private String secondOption;
    private int firstVal;
    private int secondVal;

    /**
     * Make an Object of Personality Question.
     * Every question have 2 options.
     * Value will use to be index by Character.
     * @param firstOption first Option of the question
     * @param secondOption second Option of the question
     * @param firstVal tag of first option
     * @param secondVal tag of second option
     */
    public PersonalityQuestion(String firstOption, String secondOption, int firstVal, int secondVal) {
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.firstVal = firstVal;
        this.secondVal = secondVal;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public int getFirstVal() {
        return firstVal;
    }

    public int getSecondVal() {
        return secondVal;
    }
}
