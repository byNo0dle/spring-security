package com.ufostyle.security.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/security")
public class CustomerController {

  @GetMapping("/index")
  public String index() {
    return "Hello World!!!";
  }

  @GetMapping("/index2")
  public String index2() {
    return "Hello World Not Secured!!!";
  }
}
