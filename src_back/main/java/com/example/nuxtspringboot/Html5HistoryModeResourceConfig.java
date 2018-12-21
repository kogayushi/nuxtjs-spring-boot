package com.example.nuxtspringboot;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class Html5HistoryModeResourceConfig implements WebMvcConfigurer {

  private final ResourceProperties resourceProperties;

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**")
            .addResourceLocations(resourceProperties.getStaticLocations())
            .resourceChain(false)
            .addResolver(new SpaPageResourceResolver());
  }

  public static class SpaPageResourceResolver extends PathResourceResolver {
    @Override
    protected Resource getResource(String resourcePath, Resource location) throws IOException {
      Resource resource = super.getResource(resourcePath, location);
      return resource != null ? resource : super.getResource("index.html", location);
    }
  }
}
