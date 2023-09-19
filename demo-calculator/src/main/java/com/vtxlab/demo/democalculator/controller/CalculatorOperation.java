package com.vtxlab.demo.democalculator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface CalculatorOperation {
        @GetMapping(value = "/strings")
        List<String> getStrings();

        // http://localhost:8080/api/v1/add?x=20&y=10
        @GetMapping(value = "/add")
        Integer add(@RequestParam(name = "x") int salary //
                        , @RequestParam(name = "y") int bonus,
                        @RequestParam(name = "z", required = false, defaultValue = "100") String dividend);

        @GetMapping(value = { "/subtract/{x}/{y}", "/subtract/{x}/{y}/{z}" })
        Integer subtract(@PathVariable(name = "y") int bonus,
                        @PathVariable(name = "x") int salary,
                        @PathVariable(required = false) String z);

}
