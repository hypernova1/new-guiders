package io.guiders.api.payload;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ApiResponse<T> {

    private String code;
    private String message;
    private T t;

}
