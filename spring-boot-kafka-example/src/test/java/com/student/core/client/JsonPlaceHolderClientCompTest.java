package com.student.core.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class JsonPlaceHolderClientCompTest {

    @Autowired
    JsonPlaceHolderClient client;


    @Test
    void shouldReturnJsonPlaceHolderPostsResponse() {
        //arrange

        //action
        final var posts = client.getPosts();

        //asserts
        Assertions.assertAll(
          "Checking object return",
          () -> Assertions.assertNotNull(posts),
          () -> Assertions.assertFalse(posts.isEmpty())
        );
    }

}
