package com.information.api.models;

import com.information.api.configs.InformationStatus;
import com.information.api.configs.InformationType;
import lombok.*;

import jakarta.persistence.*;

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
