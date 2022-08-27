package com.joobging.joobging.member.dto;

import com.joobging.joobging.member.domain.Authority;
import com.joobging.joobging.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MemberRequestDto {
    private String email;
    private String password;
    private String name;
    private String mbti;

    public Member toEntity(PasswordEncoder passwordEncoder){
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password)) // 비밀번호 암호화
                .name(name)
                .authority(Authority.USER)
                .mbti(mbti)
                .build();
    }
    public UsernamePasswordAuthenticationToken toAuthentication(){
        return new UsernamePasswordAuthenticationToken(email,password);
    }

}
