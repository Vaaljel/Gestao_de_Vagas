package pt.com.joelvaal.gestao_vagas.Modules.Candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "candidate")
public class CandidateEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private String name;

    @Pattern(regexp = "\\S+", message = "O campo [username] Não deve conter espaço")
    private String username;
    
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    
    @Length(min = 10, max = 100)
    private String password;
    private String descrition;
    private String curriculum;
    
    @CreationTimestamp
    private LocalDateTime creatdAt;
}
