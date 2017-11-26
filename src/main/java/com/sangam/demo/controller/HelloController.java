package com.sangam.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
 
  @GetMapping("/hello")
  public String hello() {
    return "Spring boot is available to use";
  }
}