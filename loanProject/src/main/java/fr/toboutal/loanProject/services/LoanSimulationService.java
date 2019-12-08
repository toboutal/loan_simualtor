package fr.toboutal.loanProject.services;

import fr.toboutal.loanProject.dtos.LoanSimulationDto;
import fr.toboutal.loanProject.dtos.LoanSimulationViewDto;
import sun.jvm.hotspot.debugger.Page;

import java.awt.print.Pageable;

public interface LoanSimulationService {

    void create(LoanSimulationDto dto);

    LoanSimulationViewDto getOne(Long id);
    Page<LoanSimulationViewDto> getAll(Pageable pageable);


    void update(Long id, LoanSimulationDto dto);

    void delete(Long id);

}
