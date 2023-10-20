package br.com.atech.usermanager.service.process;

import br.com.atech.usermanager.model.process.Process;
import br.com.atech.usermanager.repository.process.ProcessRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessService {
    private final ProcessRepository processRepository;

    public Process create(final Process process) {
        log.info("ProcessService.create - start - input  [{}]", process.getName());

        Process processCreated = processRepository.save(process);

        log.info("ProcessService.create - end- output [{}]", process.getId());
        return processCreated;
    }

    public Page<Process> findAByNameOrEmailOrUserName(PageRequest pageRequest, String searchTerm, String email) {
        log.info("ProcessService.findAByNameOrEmailOrUserName - start - input [{}]", searchTerm);

        Page<Process> processPage = processRepository.findAByNameOrEmailOrUserName(pageRequest, searchTerm, email);

        log.info("ProcessService.findAByNameOrEmailOrUserName - end - output [{}]", processPage.getTotalElements());
        return processPage;
    }

}
