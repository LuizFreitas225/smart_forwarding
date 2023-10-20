package br.com.atech.usermanager.api.process;

import br.com.atech.usermanager.dto.process.ProcessCreateDTO;
import br.com.atech.usermanager.dto.process.ProcessDTO;
import br.com.atech.usermanager.model.process.Process;
import br.com.atech.usermanager.model.process.StatusInspectionRequest;
import br.com.atech.usermanager.model.user.User;
import br.com.atech.usermanager.service.process.ProcessService;
import br.com.atech.usermanager.service.user.UserService;
import br.com.atech.usermanager.util.PaginationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(path = "/process")
@RequiredArgsConstructor
public class ProcessApi {

    private final UserService userService;
    private final ProcessService processService;

    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ProcessCreateDTO> create(@RequestBody @Valid ProcessCreateDTO processCreateDTO) {
        log.info("ProcessApi.create - start - input  [{}]", processCreateDTO.getName());

        Process process = modelMapper.map(processCreateDTO, Process.class);
        process.setOwner(userService.findAndValidateById(processCreateDTO.getOwnerId()));
        Process processCreated = processService.create(process);

        log.info("ProcessApi.create - end - outPut  [{}]", processCreated.getId());
        return new ResponseEntity<>(modelMapper.map(processCreateDTO, ProcessCreateDTO.class), HttpStatus.CREATED);
    }


    @GetMapping
    public List<ProcessDTO> search(
            @RequestParam(value = "page", required = false) final Integer page,
            @RequestParam(value = "size", required = false) final Integer size,
            @RequestParam(value = "sort", required = false) final String sort,
            @RequestParam(value = "orderBy", required = false) final String orderBy,
            @RequestParam(value = "searchTerm", required = false, defaultValue = "") final String searchTerm
    ) {

        log.info("UserController.search - start - input  [{},{},{},{}]", page, size, sort, searchTerm);
        Page<Process> pageReturn = processService.findAByNameOrEmailOrUserName(PaginationUtil.configuringPageable(page, size, sort, orderBy), searchTerm, userService.getUserAuthenticated().getEmail());
        return pageReturn.stream().map( value -> modelMapper.map(value, ProcessDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/{processId}/user/")
    public void inspectionRequest(@PathVariable(value = "processId")  Long processId,  Long userId) {
      Process process = processService.findAndValidateById(processId);
      User user = userService.getUserAuthenticated();

        process.setStatusInspectionRequest(StatusInspectionRequest.QUESTED);
        Process saveProcess = processService.update(process);
        user.getApprovalProcesses().add(process);
        userService.update(user);

    }


}
