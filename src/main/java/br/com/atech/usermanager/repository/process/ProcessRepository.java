package br.com.atech.usermanager.repository.process;

import br.com.atech.usermanager.model.process.Process;
import br.com.atech.usermanager.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessRepository extends JpaRepository<Process, Long> {
    List<Process> findByOwnerEmail(String email);
    @Query(value = " SELECT p FROM Process p "
            + " WHERE LOWER (p.name ) LIKE %:searchTerm% "
            + " AND LOWER (p.owner.email) LIKE %:email% ")
    Page<Process> findAByNameOrEmailOrUserName(PageRequest pageRequest, String searchTerm, String email);
}
