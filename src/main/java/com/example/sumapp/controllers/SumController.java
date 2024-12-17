package com.example.sumapp.controllers;

import com.example.sumapp.models.InputValues;
import com.example.sumapp.dto.ResultDTO;
import com.example.sumapp.services.SumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sum")
public class SumController {

    @Autowired
    private SumService sumService;

    @PostMapping
    public ResultDTO sumValues(@RequestBody InputValues inputValues) {
        int result = sumService.calculateSum(inputValues);
        return new ResultDTO(result);
    }
}
