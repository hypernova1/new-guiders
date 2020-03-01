package io.guiders.api.payload;

import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter @Setter
    public static class JoinRequest {
        private String email;
        private String name;
        private String password;
    }

}
