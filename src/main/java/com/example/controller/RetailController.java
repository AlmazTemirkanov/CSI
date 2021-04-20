package com.example.controller;

import com.example.repo.SmsSurveyRepo;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class RetailController {
    private SmsSurveyRepo smsSurveyRepo;

    @CrossOrigin
    @GetMapping("api/v2/retail/users/{start}/{end}")
    public List<Object> getAllRetailUsers (
            @PathVariable(value = "start")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @PathVariable (value = "end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        return smsSurveyRepo.getAllRetailUsers(start, end);
    }

    @CrossOrigin
    @GetMapping("api/v2/retail/managers/{start}/{end}")
    public List<Object> getAllRetail (
            @PathVariable(value = "start")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @PathVariable (value = "end")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {

        return smsSurveyRepo.getAllRetail(start, end);
    }
}
