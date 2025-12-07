package pt.com.joelvaal.gestao_vagas.Modules.company.useCases;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import pt.com.joelvaal.gestao_vagas.Modules.company.dto.AuthCompanyDTO;
import pt.com.joelvaal.gestao_vagas.Modules.company.repositories.CompanyRepository;
//import javax.naming.AuthenticationException;

@Service
public class AutCompanyUseCase {

    @Value("${security.token.security}")
    private String secretyKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder comPasswordEncoder;

    
    public String execute(AuthCompanyDTO authCompanyDTO) {  
        var company = this.companyRepository
        .findByUsername(authCompanyDTO.getUsername())
        .orElseThrow(() ->{
                throw new UsernameNotFoundException("Company not found");
            }
        );
        
        var passwordMatches = this.comPasswordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());
        if(!passwordMatches){
            throw new BadCredentialsException("Password incorreta ");
        }

        Algorithm algorithm = Algorithm.HMAC256(secretyKey);
        var token = JWT.create().withIssuer("javagas")
            .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
            .withSubject(company.getId().toString())
            .sign(algorithm);
        
    return token;
    
    }    
}
