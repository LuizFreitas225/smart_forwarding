package br.com.atech.usermanager.model.process;


import br.com.atech.usermanager.model.user.Status;
import br.com.atech.usermanager.model.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode
@EntityListeners(AuditingEntityListener.class)
@Table(name = "process")
@Data
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private String name;

    private StatusInspectionRequest statusInspectionRequest;

    @ManyToOne
    private User owner;

    private final Double latitude;
    private final Double longitude;


}
