package com.information.api.dto;

import com.information.api.configs.InformationStatus;
import com.information.api.configs.InformationType;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class InformationFilterDto {
    private List<InformationType> types;
    private List<InformationStatus> status;
    private long from;
    private long to;
}
