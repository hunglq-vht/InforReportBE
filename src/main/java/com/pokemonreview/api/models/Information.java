package com.pokemonreview.api.models;

import com.pokemonreview.api.configs.InformationStatus;
import com.pokemonreview.api.configs.InformationType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String source;

    private InformationType type;

    private String department;

    private String note;

    private String reporter;

    private InformationStatus status;

    private long createdDate;

    private long modifiedDate;
}
