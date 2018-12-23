package com.example.nuxtspringboot;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequestMapping("/api")
@RestController
public class SampleResource {
  private static List<String> LIST = Arrays.asList("太郎","次郎","三郎");
  @GetMapping(path = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
  public String hello() {
    List<String> shuffling = new ArrayList<>(LIST);
    Collections.shuffle(shuffling);
    return shuffling.get(0);
  }
}
