package com.student.core.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties(prefix = "external.api.jsonplaceholder")
public record JsonPlaceHolderProperties(
  String url,
  JsonPlaceHolderRecordPathsProperties paths) {

    public URI getUri(String path) {
        return URI.create(String.format("%s/%s", this.url, path));
    }

    public record JsonPlaceHolderRecordPathsProperties(
      String posts,
      String comments,
      String albums,
      String photos,
      String todos,
      String users
    ) {}
}

