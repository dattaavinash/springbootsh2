
package com.example.spdbconc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.spdbconc.domain.entities.BankDetails;

@FeignClient(name = "feign") 
public interface MyFeignClient {
  
  @GetMapping(path = "/bank",produces = "application/json")
   BankDetails getBankDetails();
  }
 
