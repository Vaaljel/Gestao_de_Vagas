package pt.com.joelvaal.gestao_vagas.Modules.company.repositories;

//import java.lang.classfile.ClassFile;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.joelvaal.gestao_vagas.Modules.company.entites.CompanyEntity;

public interface  CompanyRepository extends JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity>findByUsernameOrEmail(String username, String email);
    Optional<CompanyEntity> findByUsername(String username);
}
