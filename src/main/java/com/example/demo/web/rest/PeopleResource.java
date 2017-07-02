package com.example.demo.web.rest;

import com.example.demo.service.PeopleService;
import com.example.demo.service.dto.PeopleDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing People.
 */
@RestController
@RequestMapping("/api")
public class PeopleResource {

    private final Logger log = LoggerFactory.getLogger(PeopleResource.class);

    private final PeopleService peopleService;

    public PeopleResource(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    /**
     * GET  /peoples : get people sex count.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of people in body
     */
    @GetMapping("/peoples")
    public List<PeopleDTO> getCountBySex() {
        log.debug("请求性别合计数");
        return peopleService.countBySex();
    }

}
