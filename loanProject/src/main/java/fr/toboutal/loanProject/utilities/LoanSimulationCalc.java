package fr.toboutal.loanProject.utilities;

import fr.toboutal.loanProject.entities.Annuity;
import fr.toboutal.loanProject.entities.Monthly;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.List;

public class LoanSimulationCalc {
    private BigDecimal amount;
    private BigDecimal loanRate;
    private BigDecimal duration;
    private BigDecimal loanRateDividByTwelve = this.loanRate.divide(BigDecimal.valueOf(12));
    int durationInMonth = this.duration.intValue() * 12;

    public LoanSimulationCalc(BigDecimal amount, BigDecimal loanRate, BigDecimal duration) {
        this.amount = amount;
        this.loanRate = loanRate;
        this.duration = duration;
    }

    private BigDecimal firstMonthlyAmountCalc() {
        return (this.amount.multiply(this.loanRate.divide(loanRateDividByTwelve)).divide(((BigDecimal.valueOf(1).add(loanRateDividByTwelve))).pow(durationInMonth)).subtract(BigDecimal.valueOf(1)));
    }

    private BigDecimal pMonthlyAmountCalc(int p){
        return (((((BigDecimal.valueOf(1)).add(loanRateDividByTwelve)).pow(p-1)).multiply(amount)).multiply(loanRateDividByTwelve)).divide((((BigDecimal.valueOf(1)).add(loanRateDividByTwelve)).pow(durationInMonth)).subtract(BigDecimal.valueOf(1)));
    }
}
