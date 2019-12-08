package fr.toboutal.loanProject.entities;

import java.math.BigDecimal;
import java.util.List;

public class AmortizationTable {

    private List<Annuity> annuities;

    public AmortizationTable(List<Annuity> annuities) {
        this.annuities = annuities;
    }

    public List<Annuity> getAnnuities() {
        return annuities;
    }

    public void setAnnuities(List<Annuity> annuities) {
        this.annuities = annuities;
    }
}
