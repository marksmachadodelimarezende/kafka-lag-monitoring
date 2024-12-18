package com.student.entrypoint.controller;

import com.student.core.client.vo.JsonPlaceHolderPostsResponse;
import com.student.core.metrics.MetricService;
import com.student.core.service.JsonPlaceHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/api/jsonplaceholder")
@RequiredArgsConstructor
public class JsonPlaceHolderController {

    private final JsonPlaceHolderService jsonPlaceHolderService;
    private final MetricService metricService;

    @GetMapping(value = "/all-posts")
    public ResponseEntity<List<JsonPlaceHolderPostsResponse>> getPosts() {
        final var posts = jsonPlaceHolderService.getPosts();
        metricService.increment();
        return posts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(posts);
    }

    @GetMapping(value = "/posts/{id}")
    public ResponseEntity<JsonPlaceHolderPostsResponse> getPostsById(@PathVariable(value = "id") Integer id) {
        final var post = jsonPlaceHolderService.getPostsById(id);
        return Objects.nonNull(post) ? ResponseEntity.ok(post) : ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/notify/posts")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void notifyPostsById(@RequestParam(value = "id", required = false) Integer id) {
        jsonPlaceHolderService.notifyPosts(id);
    }
}
