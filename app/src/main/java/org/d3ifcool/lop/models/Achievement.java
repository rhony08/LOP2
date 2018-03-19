package org.d3ifcool.lop.models;

import org.d3ifcool.lop.R;

/**
 * Created by CHEVALIER-11 on 14-Mar-18.
 */

public class Achievement extends Data {

    private final int GOLD = R.drawable.ic_star_gold_24dp;
    private final int SILVER = R.drawable.ic_star_silver_24dp;
    private final int BRONZE = R.drawable.ic_star_bronze_24dp;
    private int image;

    /**
     * Make an Object of Data.
     *
     * @param id     unique data.
     * @param name   title of the Data.
     * @param description   description of the Data.
     * @param status ONPROGRESS, COMPLETED, FAILED
     */
    public Achievement(String id, String name, String description, int status, String type) {
        super(id, name, description, status);
        switch (type){
            case "gold":{
                this.image = GOLD;
                break;
            }
            case "silver":{
                this.image = SILVER;
                break;
            }
            default:{
                this.image = BRONZE;
                break;
            }
        }
    }

    @Override
    public int getImage() {
        return image;
    }
}
