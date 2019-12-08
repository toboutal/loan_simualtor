package fr.toboutal.loanProject.utilities;

import fr.toboutal.loanProject.dtos.LoanSimulationDto;
import fr.toboutal.loanProject.entities.AmortizationTable;
import fr.toboutal.loanProject.entities.Annuity;
import fr.toboutal.loanProject.entities.Monthly;

import java.util.List;

public abstract class AmortizationTableGeneratorTemplate {
    public abstract List<Monthly> generateMonthlies(LoanSimulationDto dto);
    public abstract AmortizationTable generateAmortizationTable(List<Monthly> monthlies);
}
