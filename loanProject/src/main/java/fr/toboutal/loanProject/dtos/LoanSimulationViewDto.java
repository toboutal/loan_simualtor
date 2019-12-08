package fr.toboutal.loanProject.dtos;

import fr.toboutal.loanProject.entities.AmortizationTable;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface LoanSimulationViewDto {
    BigDecimal getAmount();
    BigDecimal getLoanRate();
    BigDecimal getInsuranceRate();
    BigDecimal getDuration();
    String getLoanType();
    LocalDate getStartDate();
    AmortizationTable getAmortizationTable();
}
