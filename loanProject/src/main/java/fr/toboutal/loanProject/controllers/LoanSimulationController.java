package fr.toboutal.loanProject.controllers;

import fr.toboutal.loanProject.dtos.LoanSimulationDto;
import fr.toboutal.loanProject.dtos.LoanSimulationViewDto;
import fr.toboutal.loanProject.services.LoanSimulationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("loan_simulator")
@CrossOrigin
public class LoanSimulationController {
    private LoanSimulationService service;

    public LoanSimulationController(LoanSimulationService service) {
        this.service = service;
    }

    //CREATE
    @PostMapping
    protected void create(@Valid @RequestBody LoanSimulationDto dto){
        service.create(dto);
    }

    //READ
    @GetMapping("/{id}")
    protected LoanSimulationViewDto getOne(@PathVariable("id") Long id){
        return service.getOne(id);
    }

    @GetMapping()
    protected Page<LoanSimulationViewDto> getAll(@RequestParam("p") int page, @RequestParam("s") int size, @RequestParam("by") String sort) {
        Pageable pageable = (Pageable) PageRequest.of(page, size, Sort.by(sort));
        return service.getAll(pageable);
    }

    //UPDATE

    @PutMapping("/{id}")
    protected void update(@PathVariable("id") Long id, @Valid @RequestBody LoanSimulationDto dto){
        service.update(id, dto);
    }

    //DELETE

    @DeleteMapping("/{id}")
    protected void  delete(@PathVariable("id") Long id){
        service.delete(id);
    }
}
