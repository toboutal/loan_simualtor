package fr.toboutal.loanProject.repositories;

import fr.toboutal.loanProject.dtos.LoanSimulationViewDto;
import fr.toboutal.loanProject.entities.LoanSimulation;
import org.springframework.data.jpa.repository.JpaRepository;
import sun.jvm.hotspot.debugger.Page;

import java.awt.print.Pageable;

public interface LoanSimulationRepo extends JpaRepository<LoanSimulation, Long> {

    LoanSimulationViewDto getById(Long id);

    Page<LoanSimulationViewDto> getAllProjectedBy(Pageable page);


}
