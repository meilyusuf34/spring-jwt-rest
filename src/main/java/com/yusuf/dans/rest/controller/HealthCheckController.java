package com.yusuf.dans.rest.controller;

import com.yusuf.dans.common.BuildResponseUtil;
import com.yusuf.dans.dto.BaseResponse;
import com.yusuf.dans.repositories.UserAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @Autowired
    UserAccessRepository userAccessRepository;

    @GetMapping(value = "/check")
    public BaseResponse<String> check() {
        return BuildResponseUtil.success("Success.");
    }

    @GetMapping(value = "/check-db")
    public BaseResponse<String> checkDB() {
        try {
            return BuildResponseUtil.success("Database Current Timestamp : " + userAccessRepository.dBServerTime());
        } catch (Exception e) {
            e.printStackTrace();
            return BuildResponseUtil.error("DB CHECK FAILED.");
        }
    }
}
