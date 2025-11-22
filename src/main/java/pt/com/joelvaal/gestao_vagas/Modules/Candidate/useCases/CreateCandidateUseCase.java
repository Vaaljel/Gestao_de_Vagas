package pt.com.joelvaal.gestao_vagas.Modules.Candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.joelvaal.gestao_vagas.Modules.Candidate.CandidateEntity;
import pt.com.joelvaal.gestao_vagas.Modules.Candidate.CandidateRepository;
import pt.com.joelvaal.gestao_vagas.exception.UserFoundException;


@Service
public class CreateCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
         candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent((user) ->{
            throw new UserFoundException();
        });
     return candidateRepository.save(candidateEntity);
    }
    
}
