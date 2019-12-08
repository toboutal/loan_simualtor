package fr.toboutal.loanProject.entities;

import java.util.List;

public class Annuity {
    private List<Monthly> monthly;

    public Annuity(List<Monthly> monthly) {
        this.monthly = monthly;
    }

    public List<Monthly> getMonthly() {
        return monthly;
    }

    public void setMonthly(List<Monthly> monthly) {
        this.monthly = monthly;
    }
}
