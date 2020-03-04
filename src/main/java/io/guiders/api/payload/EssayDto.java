package io.guiders.api.payload;

import io.guiders.api.domain.Guider;
import io.guiders.api.domain.constant.PostType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class EssayDto {

    @Getter @Setter
    public static class Response {
       private Long id;
       private String title;
       private Guider writer;
       private String content;
       private PostType postType;
    }

    @Getter @Setter
    public static class Request {
        @NotBlank
        private String title;
        @NotBlank
        private String content;
        private PostType postType;
    }

}
