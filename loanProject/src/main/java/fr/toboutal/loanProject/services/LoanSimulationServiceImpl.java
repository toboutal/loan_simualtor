package fr.toboutal.loanProject.services;

import fr.toboutal.loanProject.dtos.LoanSimulationDto;
import fr.toboutal.loanProject.dtos.LoanSimulationViewDto;
import fr.toboutal.loanProject.entities.AmortizationTable;
import fr.toboutal.loanProject.entities.LoanSimulation;
import fr.toboutal.loanProject.repositories.LoanSimulationRepo;
import fr.toboutal.loanProject.utilities.AmortizationGenerator;
import fr.toboutal.loanProject.utilities.AmortizationTableGeneratorTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class LoanSimulationServiceImpl implements LoanSimulationService {

    private LoanSimulationRepo loanSimulationRepo;
    private AmortizationTableGeneratorTemplate amortizationTableGenerator;

    public LoanSimulationServiceImpl(LoanSimulationRepo loanSimulationRepo) {
        this.loanSimulationRepo = loanSimulationRepo;
        this.amortizationTableGenerator = new AmortizationGenerator();
    }

    @Override
    public void create(LoanSimulationDto dto) {
        LoanSimulation loanSimulation = new LoanSimulation();
        populate(dto, loanSimulation);
    }

    @Override
    public LoanSimulationViewDto getOne(Long id) {
        return loanSimulationRepo.getById(id);
    }

    @Override
    public Page<LoanSimulationViewDto> getAll(Pageable pageable) {
        return loanSimulationRepo.getAllProjectedBy(pageable);
    }

    @Override
    public void update(Long id, LoanSimulationDto dto) {
        LoanSimulation loanSimulation = loanSimulationRepo.findById(id).get();
        populate(dto, loanSimulation);
    }

    @Override
    public void delete(Long id) {
        loanSimulationRepo.deleteById(id);
    }

    private void populate(LoanSimulationDto dto, LoanSimulation loanSimulation) {
        loanSimulation.setAmount(dto.getAmount());
        loanSimulation.setLoanRate(dto.getLoanRate());
        loanSimulation.setLoanType(dto.getLoanType());
        loanSimulation.setInsuranceRate(dto.getInsuranceRate());
        loanSimulation.setDuration(dto.getDuration());
        loanSimulation.setStartDate(dto.getStartDate());
        loanSimulation.setAmortizationTable((AmortizationTable) amortizationTableGenerator.generateAmortizationTable(amortizationTableGenerator.generateMonthlies(dto)));
    }
}
