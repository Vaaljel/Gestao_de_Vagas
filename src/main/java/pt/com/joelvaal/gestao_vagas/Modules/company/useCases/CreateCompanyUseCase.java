package pt.com.joelvaal.gestao_vagas.Modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pt.com.joelvaal.gestao_vagas.Modules.company.entites.CompanyEntity;
import pt.com.joelvaal.gestao_vagas.Modules.company.repositories.CompanyRepository;
import pt.com.joelvaal.gestao_vagas.exception.UserFoundException;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CompanyRepository companyRepository;

    public  CompanyEntity execute(CompanyEntity companyEntity){
        this.companyRepository
        .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
        .ifPresent((user) ->{
            throw new UserFoundException();
        });
        
        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);
        
        return this.companyRepository.save(companyEntity);
    }
}
