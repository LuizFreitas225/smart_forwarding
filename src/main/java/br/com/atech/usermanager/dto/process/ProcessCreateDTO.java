package br.com.atech.usermanager.dto.process;

import br.com.atech.usermanager.constant.ErrorMessage;
import br.com.atech.usermanager.model.process.StatusInspectionRequest;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ProcessCreateDTO {
    @NotBlank(message = ErrorMessage.NAME_IS_MANDATORY)
    private String name;
    @NotNull(message = ErrorMessage.OWNER_ID_IS_MANDATORY)
    private Long ownerId;
    @NotNull(message = ErrorMessage.PROFILE_IS_MANDATORY)
    private StatusInspectionRequest statusInspectionRequest;
    @NotNull(message = ErrorMessage.LATITUDE_IS_MANDATORY)
    private final Double latitude;
    @NotNull(message = ErrorMessage.LONGITUDE_IS_MANDATORY)
    private final Double longitude;
}
