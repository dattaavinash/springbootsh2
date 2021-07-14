
package com.example.spdbconc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign",url = "http://localhost:8081/bank") 
public interface MyFeignClient {
  
  @GetMapping(path = "/details", produces = "application/json")
   String getBankDetails();
  }
 

