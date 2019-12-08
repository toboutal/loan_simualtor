package fr.toboutal.loanProject.repositories;

import fr.toboutal.loanProject.dtos.LoanSimulationViewDto;
import fr.toboutal.loanProject.entities.LoanSimulation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanSimulationRepo extends JpaRepository<LoanSimulation, Long> {

    LoanSimulationViewDto getById(Long id);

    Page<LoanSimulationViewDto> getAllProjectedBy(Pageable page);


}
