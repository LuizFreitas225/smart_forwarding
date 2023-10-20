package br.com.atech.usermanager.dto.process;

import br.com.atech.usermanager.model.process.StatusInspectionRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProcessDTO {
    private Long id;

    private LocalDateTime createDate;


    private LocalDateTime lastModifiedDate;

    private String name;

    private StatusInspectionRequest statusInspectionRequest;


    private String ownerName;

    private  Double latitude ;
    private  Double longitude;
}
