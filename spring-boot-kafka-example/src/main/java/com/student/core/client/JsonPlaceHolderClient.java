package com.student.core.client;

import com.student.core.client.vo.JsonPlaceHolderPostsResponse;
import com.student.core.config.JsonPlaceHolderProperties;
import com.student.core.exception.JsonPlaceHolderApiException;
import com.student.core.utils.FailSafeUtils;
import com.student.core.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import static com.student.core.utils.HttpClientUtils.sendHttpClient;

@RequiredArgsConstructor
@Component
public class JsonPlaceHolderClient {

    private static final Logger log = LoggerFactory.getLogger(JsonPlaceHolderClient.class);
    private final JsonPlaceHolderProperties props;

    public List<JsonPlaceHolderPostsResponse> getPosts() {
        return FailSafeUtils.defaultFailSafe().get(ctx -> callAllPosts());
    }

    public JsonPlaceHolderPostsResponse getPostsById(Integer id) {
        return FailSafeUtils.defaultFailSafe().get(ctx -> callPostsById(id));
    }

    private List<JsonPlaceHolderPostsResponse> callAllPosts() throws IOException, InterruptedException {
        HttpResponse<String> httpResponse = sendHttpClient(props.getUri(props.paths().posts()));
        validateResponse(httpResponse);
        return List.of(JsonUtils.fromJson(httpResponse.body(), JsonPlaceHolderPostsResponse[].class));
    }

    private JsonPlaceHolderPostsResponse callPostsById(Integer id) throws IOException, InterruptedException {
        HttpResponse<String> httpResponse = sendHttpClient(
          props.getUri(props.paths().posts().concat("/").concat(id.toString())));
        validateResponse(httpResponse);
        return JsonUtils.fromJson(httpResponse.body(), JsonPlaceHolderPostsResponse.class);
    }

    private static void validateResponse(HttpResponse<String> httpResponse) {
        HttpStatus httpStatus = HttpStatus.valueOf(httpResponse.statusCode());
        String path = httpResponse.uri().getPath();
        if (httpStatus.is4xxClientError()) {
            throw new JsonPlaceHolderApiException(httpStatus, httpResponse.body(), path);
        }
    }

}
