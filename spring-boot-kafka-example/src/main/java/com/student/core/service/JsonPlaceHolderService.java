package com.student.core.service;

import com.student.core.client.JsonPlaceHolderClient;
import com.student.core.client.vo.JsonPlaceHolderPostsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
@Slf4j
@RequiredArgsConstructor
public class JsonPlaceHolderService {

    private final JsonPlaceHolderClient jsonPlaceHolderClient;
    private final DispatcherJsonPlaceHolderService dispatcherJsonPlaceHolderService;

    public List<JsonPlaceHolderPostsResponse> getPosts() {
        return jsonPlaceHolderClient.getPosts();
    }

    public JsonPlaceHolderPostsResponse getPostsById(Integer id) {
        final var post = jsonPlaceHolderClient.getPostsById(id);
        return nonNull(post) && nonNull(post.getId()) ? post : null;
    }

    public void notifyPosts(Integer id) {
        if (nonNull(id)) {
            notifyPostsById(id);
        } else {
            notifyAllPosts();
        }
    }

    private void notifyAllPosts() {
        getPosts().forEach(this.dispatcherJsonPlaceHolderService::notify);
    }

    private void notifyPostsById(Integer id) {
        Optional.ofNullable(this.getPostsById(id)).ifPresent(this.dispatcherJsonPlaceHolderService::notify);
    }
}
