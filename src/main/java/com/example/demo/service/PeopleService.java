package com.example.demo.service;

import com.example.demo.repository.PeopleRepository;
import com.example.demo.service.dto.PeopleDTO;
import com.example.demo.service.mapper.PeopleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing People.
 */
@Service
@Transactional
public class PeopleService {

    private final Logger log = LoggerFactory.getLogger(PeopleService.class);

    private final PeopleRepository peopleRepository;

    private final PeopleMapper peopleMapper;

    public PeopleService(PeopleRepository peopleRepository, PeopleMapper peopleMapper) {
        this.peopleRepository = peopleRepository;
        this.peopleMapper = peopleMapper;
    }

    /**
     *  Get people's sex count.
     *
     *  @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<PeopleDTO> countBySex() {
        log.debug("获取性别合计数");
        List<String> peopleList = peopleRepository.findDistinctSex();
        return peopleList.parallelStream()
                .map(peopleMapper::sexToProductDTO)
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
