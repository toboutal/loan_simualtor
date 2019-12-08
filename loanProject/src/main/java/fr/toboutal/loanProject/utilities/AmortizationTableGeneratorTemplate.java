package fr.toboutal.loanProject.utilities;

import fr.toboutal.loanProject.entities.Annuity;
import fr.toboutal.loanProject.entities.Monthly;

import java.util.List;

public abstract class AmortizationTableGenerator {
    public abstract List<Annuity> generateAnnuities();
    public abstract List<Monthly> generateMonthlies();
}
