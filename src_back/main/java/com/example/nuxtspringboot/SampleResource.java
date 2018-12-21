package com.example.nuxtspringboot;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class SampleResource {

  @GetMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String hello() {
    return "ブロリー";
  }
}
