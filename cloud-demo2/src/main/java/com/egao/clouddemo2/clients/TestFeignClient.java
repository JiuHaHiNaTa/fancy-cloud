package com.egao.clouddemo2.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.zip.Inflater;

@FeignClient("clouddemo")
public interface TestFeignClient {

    @GetMapping(value = "/hello",consumes = "application/json")
    public String testFeign(@RequestParam("id") String id);
}
