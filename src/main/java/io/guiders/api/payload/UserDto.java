package io.guiders.api.payload;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class UserDto {

    @Getter @Setter
    public static class JoinRequest {
        @NotBlank
        private String email;
        @NotBlank
        private String name;
        @NotBlank
        private String password;
    }

    @Getter @Setter
    public static class LoginRequest {
        @NotBlank
        private String email;
        @NotBlank
        private String password;
    }

}
