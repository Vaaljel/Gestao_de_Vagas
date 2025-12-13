package pt.com.joelvaal.gestao_vagas.Modules.Candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pt.com.joelvaal.gestao_vagas.Modules.Candidate.CandidateEntity;
import pt.com.joelvaal.gestao_vagas.Modules.Candidate.CandidateRepository;
import pt.com.joelvaal.gestao_vagas.exception.UserFoundException;


@Service
public class CreateCandidateUseCase {
   

    @Autowired
    private CandidateRepository candidateRepository;

     
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public CandidateEntity execute(CandidateEntity candidateEntity){
         candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) ->{
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);
        
     return candidateRepository.save(candidateEntity);
    }
    
}
