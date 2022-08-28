package com.joobging.joobging.member.service;


import com.joobging.joobging.config.TokenProvider;
import com.joobging.joobging.member.domain.Member;
import com.joobging.joobging.member.dto.MemberRequestDto;
import com.joobging.joobging.member.dto.MemberResponseDto;
import com.joobging.joobging.member.dto.TokenDto;
import com.joobging.joobging.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManagerBuilder managerBuilder;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    @Transactional
    public MemberResponseDto signUp(MemberRequestDto requestDto){
        Member member = requestDto.toEntity(passwordEncoder);
        return MemberResponseDto.of(memberRepository.save(member));
    }

    @Transactional
    public TokenDto signIn(MemberRequestDto requestDto){
        UsernamePasswordAuthenticationToken authenticationToken = requestDto.toAuthentication();
        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        TokenDto tokenDto =  tokenProvider.generateTokenDto(authentication);
        Optional<Member> memberResponseDto = memberRepository.findByEmail(requestDto.getEmail());
        tokenDto.setMemberId(memberResponseDto.get().getId());
        return tokenDto;
    }

    //return new SignInResponseDto(token, member.getId(), member.getNickName(), member.getMbti()); // 발급된 토큰과 유저 고유 id 반환

}
