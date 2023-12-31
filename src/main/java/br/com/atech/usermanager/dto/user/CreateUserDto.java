package br.com.atech.usermanager.dto.user;

import br.com.atech.usermanager.constant.ErrorMessage;
import br.com.atech.usermanager.model.regional.RegionalAgencyNaturatins;
import br.com.atech.usermanager.model.user.Profile;
import br.com.atech.usermanager.model.user.Status;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateUserDto {
    @NotBlank(message = ErrorMessage.NAME_IS_MANDATORY)
    private String name;
    @NotBlank(message = ErrorMessage.EMAIL_IS_MANDATORY)
    @Email(message = ErrorMessage.VALID_EMAIL_IS_REQUIRED)
    private String email;
    @NotBlank(message = ErrorMessage.PASSWORD_IS_MANDATORY)
    private String password;
    @NotBlank(message = ErrorMessage.USER_NAME_IS_MANDATORY)
    private String userName;
    @NotNull(message = ErrorMessage.STATUS_IS_MANDATORY)
    private Status status;
    @NotNull(message = ErrorMessage.PROFILE_IS_MANDATORY)
    private Profile profile;
    @NotNull(message = ErrorMessage.REGIONAL_AGENCY_IS_MANDATORY)
    private RegionalAgencyNaturatins regionalAgencyNaturatins;
}
