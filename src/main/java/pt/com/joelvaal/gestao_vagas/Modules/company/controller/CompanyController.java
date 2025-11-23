package pt.com.joelvaal.gestao_vagas. Modules.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pt.com.joelvaal.gestao_vagas.Modules.company.useCases.CreateCompanyUseCase;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    public CompanyEntity create(@Valid @RequestBody CompanyEntity companyEntity){
        return this.createCompanyUseCase.execute(companyEntity);
    }
    
}
