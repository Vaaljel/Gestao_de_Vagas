package pt.com.joelvaal.gestao_vagas.Modules.company.entites;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name="company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private  String website;
    private String  name;
    
    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] Não deve conter espaço")
    private String username;
    
    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;
    
    @Length(min = 10, max = 100)
    private String password;

    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    
}
