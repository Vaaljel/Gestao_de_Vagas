package pt.com.joelvaal.gestao_vagas.Modules.company.entites;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="job")
public class JobEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private String description;
    private String benefits;
    private String level;

    @ManyToOne
    @JoinColumn(name="company_id", insertable =  false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name="companu_id")
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
