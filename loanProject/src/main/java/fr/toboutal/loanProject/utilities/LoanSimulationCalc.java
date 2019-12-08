package fr.toboutal.loanProject.utilities;

import fr.toboutal.loanProject.entities.Annuity;
import fr.toboutal.loanProject.entities.Monthly;

import javax.annotation.Generated;
import java.math.BigDecimal;
import java.util.List;

public class LoanSimulationCalc {
    private BigDecimal loanRate;
    private BigDecimal duration;
    private BigDecimal loanRateDividByTwelve = this.loanRate.divide(BigDecimal.valueOf(12));
    int durationInMonth = this.duration.intValue() * 12;

    public LoanSimulationCalc(BigDecimal loanRate, BigDecimal duration) {
        this.loanRate = loanRate;
        this.duration = duration;
    }

    protected BigDecimal firstMonthlyAmountCalc(BigDecimal amount) {
        return (amount.multiply(this.loanRate.divide(loanRateDividByTwelve)).divide(((BigDecimal.valueOf(1).add(loanRateDividByTwelve))).pow(durationInMonth)).subtract(BigDecimal.valueOf(1)));
    }

    protected BigDecimal pMonthlyAmountCalc(BigDecimal amount, int p){
        return (((((BigDecimal.valueOf(1)).add(loanRateDividByTwelve)).pow(p-1)).multiply(amount)).multiply(loanRateDividByTwelve)).divide((((BigDecimal.valueOf(1)).add(loanRateDividByTwelve)).pow(durationInMonth)).subtract(BigDecimal.valueOf(1)));
    }

    protected BigDecimal monthlyInterestsCalc(BigDecimal monthlyAmount) {
        return monthlyAmount.multiply(loanRate.divide(BigDecimal.valueOf(100)));
    }

    protected BigDecimal monthlyInsuranceCalc(BigDecimal monthlyAmount, BigDecimal insuranceRate) {
        return monthlyAmount.multiply(insuranceRate.divide(BigDecimal.valueOf(100)));
    }

    protected BigDecimal monthlyCapitalOutstanding(BigDecimal amount, BigDecimal amortizedCapital) {
        return amount.subtract(amortizedCapital);
    }

    protected BigDecimal monthlyTotalAmount(BigDecimal amount, BigDecimal insurance) {
        return amount.add(insurance);
    }


}
