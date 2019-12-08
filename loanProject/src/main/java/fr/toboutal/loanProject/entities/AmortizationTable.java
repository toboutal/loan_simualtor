package fr.toboutal.loanProject.entities;

import java.math.BigDecimal;
import java.util.List;

public class AmortizationTable {
    private BigDecimal amount;
    private BigDecimal loanRate;
    private BigDecimal duration;
    private List<Annuity> annuities;

    public AmortizationTable(BigDecimal amount, BigDecimal loanRate, BigDecimal duration) {
        this.amount = amount;
        this.loanRate = loanRate;
        this.duration = duration;


    }

    private BigDecimal getFirstFirstMonthly() {
        int durationInMonth = this.duration.intValue() * 12;
        return (this.amount.multiply(this.loanRate.divide(BigDecimal.valueOf(12)))).divide((BigDecimal.ONE.add(this.loanRate).divide(BigDecimal.valueOf(12))).pow(durationInMonth));
    }

    private List<Annuity> getAnnuities(){
        BigDecimal  firstMonthly =  getFirstFirstMonthly();

    }
}
