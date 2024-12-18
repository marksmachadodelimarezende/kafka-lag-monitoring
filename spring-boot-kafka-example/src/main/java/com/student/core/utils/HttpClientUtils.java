package com.student.core.utils;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@UtilityClass
public class HttpClientUtils {

    public static HttpResponse<String> sendHttpClient(URI uri) throws IOException, InterruptedException {
        return sendHttpClient(defaultHttpRequest(uri));
    }

    public static HttpResponse<String> sendHttpClient(HttpRequest request) throws IOException, InterruptedException {
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static HttpRequest defaultHttpRequest(URI uri) {
        return HttpRequest.newBuilder()
          .header("Accept", "application/json")
          .uri(uri)
          .method("GET", HttpRequest.BodyPublishers.noBody() )
          .build();
    }
}
