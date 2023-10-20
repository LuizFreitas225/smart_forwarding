package br.com.atech.usermanager.model.user;


import br.com.atech.usermanager.model.process.Process;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
    private String name;
    @Column(unique = true)
    private String email;
    private String password;
    private String userName;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Profile profile;

    @OneToMany
    private List<Process> Process;
}
