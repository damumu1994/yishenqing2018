package com.cmct.ysq.model.bo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JwtTokenKeys {

    private String header = "tunnel-token";

    private String secret = "defaultSecret";

    private Long expiration = 604800L;

    private String authPath = "auth";

    private String md5Key = "randomKey";
}
