package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for Decomposition of the quality factor.
 */
@Service
public class DecompositionService {

    private final Logger log = LoggerFactory.getLogger(DecompositionService.class);

    public DecompositionService() {
    }

    /**
     *  Get number.
     *
     *  @return the comput result
     */
    public String getResult(Long number) {
        log.debug("开始因式分解");
        int flag = 0;
        String[] str = new String[1000];
        for (long i = 2; i <= number; i++) {
            if (number % i == 0) {
                str[flag] = Long.toString(i);
                flag++;
                number = number / i;
                i--;
            }
        }
        String result = "=" + str[0];
        for (int k = 1; k < flag; k++) {
            result += "*" + str[k];
        }
        return result;
    }

}
