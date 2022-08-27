package com.joobging.joobging.member.controller;


import com.joobging.joobging.member.dto.MemberRequestDto;
import com.joobging.joobging.member.dto.MemberResponseDto;
import com.joobging.joobging.member.dto.TokenDto;
import com.joobging.joobging.member.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto){
        return ResponseEntity.ok(authService.signUp(requestDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<TokenDto> signin(@RequestBody MemberRequestDto requestDto){
        System.out.println("ok");
        return ResponseEntity.ok(authService.signIn(requestDto));
    }
}
