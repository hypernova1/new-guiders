package io.guiders.api.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
        @NotBlank
        private String memberType;
    }

    @Getter @Setter
    public static class LoginRequest {
        @NotBlank
        private String email;
        @NotBlank
        private String password;
    }

    @Getter @Setter
    public static class ModifyRequest {
        Long id;
        @NotBlank
        private String name;
        @NotBlank
        @JsonIgnoreProperties
        private String password;
    }

    @Getter @Setter
    public static class UserResponse {
        @NotBlank
        private String email;
        @NotBlank
        private String name;
        @NotBlank
        private String memberType;
    }

}
