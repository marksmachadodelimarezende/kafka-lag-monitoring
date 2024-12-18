package com.student.core.service;

import com.student.core.client.KafkaClientService;
import com.student.core.client.vo.JsonPlaceHolderPostsResponse;
import com.student.core.enums.TopicEnum;
import com.student.core.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
@Slf4j
public class DispatcherJsonPlaceHolderService {

    private final KafkaClientService kafkaClientService;

    public void notify(JsonPlaceHolderPostsResponse posts) {
        ofNullable(JsonUtils.toJson(posts))
          .ifPresentOrElse(
            json -> kafkaClientService.send(
              TopicEnum.TopicNames.JSON_PLACE_HOLDER_POSTS_TOPIC,
              String.valueOf(posts.getId()),
              json),
            () -> log.error("status=message-not-dispatcher, message=Could not convert to json"));
    }
}
