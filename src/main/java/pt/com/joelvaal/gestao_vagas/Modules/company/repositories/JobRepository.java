package pt.com.joelvaal.gestao_vagas.Modules.company.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.joelvaal.gestao_vagas.Modules.company.entites.JobEntity;

public interface  JobRepository extends JpaRepository<JobEntity, UUID>{
    
}
