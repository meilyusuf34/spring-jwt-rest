package com.yusuf.dans.rest.controller;

import com.yusuf.dans.common.RestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class JobController {

    @Value("${url.dans.job-list}")
    private String urlJobList;
    @Value("${url.dans.job-detail}")
    private String urlJobDetail;

    private final RestUtils restUtils;
    public JobController(RestUtils restUtils) {
        this.restUtils = restUtils;
    }

    @GetMapping("/list")
    public ResponseEntity<String> jobList()   {
        return restUtils.sendGetRequest(urlJobList, String.class);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<String> jobDetail(@PathVariable("id") String id)  {
        return restUtils.sendGetRequest(urlJobDetail + id , String.class);
    }

}
