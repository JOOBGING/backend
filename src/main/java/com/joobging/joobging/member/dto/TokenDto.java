package com.joobging.joobging.member.dto;

import com.joobging.joobging.member.domain.Member;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class TokenDto {
    private String grantType;
    private String accessToken;
    private Long tokenExpiresIn;
    private Long memberId;

    public TokenDto(Member member){
        this.memberId = member.getId();
    }
}
