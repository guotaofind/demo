package com.example.demo.web.rest;

import com.example.demo.service.DecompositionService;
import com.example.demo.service.dto.ResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing Decomposition.
 */
@RestController
@RequestMapping("/api")
public class DecompositionResource {

    private final Logger log = LoggerFactory.getLogger(PeopleResource.class);

    private final DecompositionService decompositionService;

    public DecompositionResource(DecompositionService decompositionService) {
        this.decompositionService = decompositionService;
    }

    @PostMapping("/decomposition")
    public ResponseEntity<ResultDTO> getResult(@RequestBody Long number) {
        log.debug("接收参数");
        ResultDTO resultDTO = new ResultDTO(decompositionService.getResult(number));
        return ResponseEntity.ok().body(resultDTO);
    }

}
