package fr.toboutal.loanProject.services;

import fr.toboutal.loanProject.dtos.LoanSimulationDto;
import fr.toboutal.loanProject.dtos.LoanSimulationViewDto;
import fr.toboutal.loanProject.entities.AmortizationTable;
import fr.toboutal.loanProject.entities.LoanSimulation;
import fr.toboutal.loanProject.repositories.LoanSimulationRepo;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.Page;

import java.awt.print.Pageable;

@Service
public class LoanSimulationServiceImpl implements LoanSimulationService {

    private LoanSimulationRepo loanSimulationRepo;
    private AmortizationTable amortizationTable;

    public LoanSimulationServiceImpl(LoanSimulationRepo loanSimulationRepo) {
        this.loanSimulationRepo = loanSimulationRepo;
    }

    @Override
    public void create(LoanSimulationDto dto) {
        LoanSimulation loanSimulation = new LoanSimulation();
        populate(dto, loanSimulation);
    }

    @Override
    public LoanSimulationViewDto getOne(Long id) {
        return loanSimulationRepo.get;
    }

    @Override
    public Page<LoanSimulationViewDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public void update(Long id, LoanSimulationDto dto) {

    }

    @Override
    public void delete(Long id) {

    }

    private void populate(LoanSimulationDto dto, LoanSimulation loanSimulation) {
        loanSimulation.setAmount(dto.getAmount());
        loanSimulation.setLoanRate(dto.getLoanRate());
        loanSimulation.setLoanType(dto.getLoanType());
        loanSimulation.setInsuranceRate(dto.getInsuranceRate());
        loanSimulation.setDuration(dto.getDuration());
        loanSimulation.setStartDate(dto.getStartDate());
    }
}
