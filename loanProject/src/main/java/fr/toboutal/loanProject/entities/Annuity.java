package fr.toboutal.loanProject.entities;

import java.math.BigDecimal;
import java.util.List;

public class Annuity {
    private BigDecimal amortizedCapital;
    private BigDecimal interests;
    private BigDecimal capitalOutstanding;
    private BigDecimal amount;
    private BigDecimal insurance;
    private BigDecimal totalAmount;
    private List<Monthly> monthlies;

    public Annuity() {
        this.amortizedCapital = BigDecimal.valueOf(0);
        this.interests = BigDecimal.valueOf(0);
        this.capitalOutstanding = BigDecimal.valueOf(0);
        this.amount = BigDecimal.valueOf(0);
        this.insurance = BigDecimal.valueOf(0);
        this.totalAmount = BigDecimal.valueOf(0);
    }

    public BigDecimal getAmortizedCapital() {
        return amortizedCapital;
    }

    public void setAmortizedCapital(BigDecimal amortizedCapital) {
        this.amortizedCapital = amortizedCapital;
    }

    public BigDecimal getInterests() {
        return interests;
    }

    public void setInterests(BigDecimal interests) {
        this.interests = interests;
    }

    public BigDecimal getCapitalOutstanding() {
        return capitalOutstanding;
    }

    public void setCapitalOutstanding(BigDecimal capitalOutstanding) {
        this.capitalOutstanding = capitalOutstanding;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public void setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Monthly> getMonthlies() {
        return monthlies;
    }

    public void setMonthlies(List<Monthly> monthlies) {
        this.monthlies = monthlies;
    }
}
