package com.student.core.client.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPostsResponse {
    @JsonProperty
    private Long userId;
    @JsonProperty
    private Long id;
    @JsonProperty
    private String title;
    @JsonProperty
    private String body;
}
