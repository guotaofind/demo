package com.example.demo.service.dto;

/**
 * A DTO for the People entity.
 */
public class PeopleDTO {

    private String sex;

    private Long count;

    public PeopleDTO(String sex, Long count) {
        this.sex = sex;
        this.count = count;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

}
