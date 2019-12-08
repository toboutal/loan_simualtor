package fr.toboutal.loanProject.dtos;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class LoanSimulationDto {
    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    @PositiveOrZero
    private BigDecimal loanRate;

    @NotBlank
    private String loanType;

    @NotNull
    @PositiveOrZero
    private BigDecimal insuranceRate;

    @NotNull
    @Positive
    private BigDecimal duration;

    @NotNull
    @FutureOrPresent
    private LocalDate startDate;

    public LoanSimulationDto() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getLoanRate() {
        return loanRate;
    }

    public void setLoanRate(BigDecimal loanRate) {
        this.loanRate = loanRate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public BigDecimal getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(BigDecimal insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
