package br.com.atech.usermanager.dto.user;

import br.com.atech.usermanager.model.user.Profile;
import br.com.atech.usermanager.model.user.Status;
import lombok.Data;

import java.time.LocalDateTime;


@Data
public class UserProfileDto {
    private Long id;
    private LocalDateTime createDate;
    private LocalDateTime lastModifiedDate;
    private String name;
    private String email;
    private String password;
    private String userName;
    private Status status;
    private Profile profile;
}
