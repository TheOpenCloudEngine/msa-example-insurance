package com.auto.insurance;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by uengine on 2018. 10. 25..
 */
@FeignClient(name = "credit-service", url="http://localhost:9997")
public interface CreditService {

    @RequestMapping(path="/credits/{ssn}", method= RequestMethod.GET)
    public Credit getCredit(@PathVariable("ssn") String ssn);

}


