package com.student.core.enums;

import com.student.core.model.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TopicEnum {

    JSON_PLACE_HOLDER_POSTS(Topic.builder()
      .name(TopicNames.JSON_PLACE_HOLDER_POSTS_TOPIC)
      .build())
    ;

    private final Topic topic;

    public static class TopicNames {
        public static final String JSON_PLACE_HOLDER_POSTS_TOPIC = "sys.student.json-place-holder.posts";
    }

}
