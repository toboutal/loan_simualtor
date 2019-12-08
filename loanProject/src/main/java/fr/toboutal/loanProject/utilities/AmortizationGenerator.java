package fr.toboutal.loanProject.utilities;

import fr.toboutal.loanProject.dtos.LoanSimulationDto;
import fr.toboutal.loanProject.entities.AmortizationTable;
import fr.toboutal.loanProject.entities.Annuity;
import fr.toboutal.loanProject.entities.Monthly;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AmortizationGenerator extends AmortizationTableGeneratorTemplate{

    @Override
    public List<Monthly> generateMonthlies(LoanSimulationDto dto) {
        final LoanSimulationCalc calc = new LoanSimulationCalc(dto.getLoanRate(), dto.getDuration());
        final int loanDurationInMonth = dto.getDuration().intValue() * 12;
        List<Monthly> monthlies = new ArrayList();
        for (int i = 0; i < loanDurationInMonth ; i++) {
            final Monthly monthly = new Monthly();
            BigDecimal amortizedCapital = null;
            if(i == 0) {
                monthly.setAmount(calc.firstMonthlyAmountCalc(dto.getAmount()));
                amortizedCapital = monthly.getAmount();
                setMonthly(dto, calc, monthly, amortizedCapital);
                monthlies.add(monthly);
            } else {
                monthly.setAmount(calc.pMonthlyAmountCalc(dto.getAmount(), i));
                amortizedCapital.add(monthly.getAmount());
                setMonthly(dto, calc, monthly, amortizedCapital);
                monthlies.add(monthly);
            }
        }
        return monthlies;
    }

    private void setMonthly(LoanSimulationDto dto, LoanSimulationCalc calc, Monthly monthly, BigDecimal amortizedCapital) {
        monthly.setAmortizedCapital(amortizedCapital);
        monthly.setInterests(calc.monthlyInterestsCalc(monthly.getAmount()));
        monthly.setInsurance(calc.monthlyInsuranceCalc(monthly.getAmount(), dto.getInsuranceRate()));
        monthly.setCapitalOutstanding(calc.monthlyCapitalOutstanding(monthly.getAmount(), monthly.getInsurance()));
        monthly.setTotalAmount(calc.monthlyTotalAmount(monthly.getAmount(), monthly.getInsurance()));
    }

    @Override
    public AmortizationTable generateAmortizationTable(List<Monthly> monthlies) {
        List<Annuity> annuities = new ArrayList();
        int i = 0;
        for (Monthly monthly: monthlies) {
            i++;
            List<Monthly> annuityMonth = new ArrayList();
            annuityMonth.add(monthly);
            if(i % 12 == 0 && i > 0) {
                Annuity annuity = new Annuity();
                annuity.setMonthlies(annuityMonth);
                for (Monthly month: annuity.getMonthlies()) {
                    annuity.setAmortizedCapital(annuity.getAmortizedCapital().add(month.getAmount()));
                    annuity.setInterests(annuity.getInterests().add(month.getInterests()));
                    annuity.setCapitalOutstanding(annuity.getCapitalOutstanding().add(month.getCapitalOutstanding()));
                    annuity.setAmount(annuity.getAmount().add(month.getAmount()));
                    annuity.setInsurance(annuity.getInsurance().add(month.getInsurance()));
                    annuity.setTotalAmount(annuity.getTotalAmount().add(month.getTotalAmount()));
                }
                annuityMonth.clear();
                annuities.add(annuity);
            }

        }
        return new AmortizationTable(annuities);
    }
}
