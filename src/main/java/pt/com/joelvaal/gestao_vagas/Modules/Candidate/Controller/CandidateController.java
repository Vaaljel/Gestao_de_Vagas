package pt.com.joelvaal.gestao_vagas.Modules.Candidate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pt.com.joelvaal.gestao_vagas.Modules.Candidate.CandidateEntity;
import pt.com.joelvaal.gestao_vagas.Modules.Candidate.useCases.CreateCandidateUseCase;


@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private  CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity){  
      try {
           var result = this.createCandidateUseCase.execute(candidateEntity);
           return ResponseEntity.ok().body(result);
       } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }    
}
 