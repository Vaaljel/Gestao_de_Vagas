package pt.com.joelvaal.gestao_vagas.Modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.joelvaal.gestao_vagas.Modules.company.entites.JobEntity;
import pt.com.joelvaal.gestao_vagas.Modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity){
        return this.jobRepository.save(jobEntity);

    }

}
