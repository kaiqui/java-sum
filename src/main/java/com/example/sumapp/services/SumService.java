package com.example.sumapp.services;

import com.example.sumapp.models.InputValues;
import org.springframework.stereotype.Service;

@Service
public class SumService {
    public int calculateSum(InputValues input) {
        return input.getValues().stream().mapToInt(Integer::intValue).sum();
    }
}
