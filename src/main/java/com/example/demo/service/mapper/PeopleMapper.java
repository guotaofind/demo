package com.example.demo.service.mapper;

import com.example.demo.repository.PeopleRepository;
import com.example.demo.service.dto.PeopleDTO;
import org.springframework.stereotype.Service;

/**
 * Mapper for the PeopleDTO.
 */
@Service
public class PeopleMapper {

    private final PeopleRepository peopleRepository;

    public PeopleMapper(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public PeopleDTO sexToProductDTO(String sex) {
       return new PeopleDTO(sex, peopleRepository.countBySex(sex));
    }

}
