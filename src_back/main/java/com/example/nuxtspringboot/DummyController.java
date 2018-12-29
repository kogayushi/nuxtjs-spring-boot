package com.example.nuxtspringboot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Profile("local")
@Controller
public class DummyController {

  @GetMapping("/**")
  public String dummyTop() {
    return "redirect:http://localhost:3000";
  }
}
