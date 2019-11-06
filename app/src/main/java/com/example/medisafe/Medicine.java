package com.example.medisafe;

public class Medicine {

    public String drugs;
    public String pills;

    public String getdrugname() {
        return drugs;
    }

    public String getpills() {
        return pills;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public void setPills(String pills) {
        this.pills = pills;
    }


    public Medicine(String drugs, String pills) {
        this.drugs = drugs;
        this.pills = pills;
    }
}
