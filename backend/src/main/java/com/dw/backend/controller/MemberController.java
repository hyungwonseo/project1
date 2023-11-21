package com.dw.backend.controller;

import com.dw.backend.dto.BaseResponse;
import com.dw.backend.dto.MemberDto;
import com.dw.backend.dto.MemberLoginDto;
import com.dw.backend.enumstatus.ResultCode;
import com.dw.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="http://localhost:3000",
        methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE})
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        super();
        this.memberService = memberService;
    }

    @PostMapping("/api/signup")
    public ResponseEntity<BaseResponse<Void>> signUp(@RequestBody @Valid MemberDto memberDto) {
        return new ResponseEntity<BaseResponse<Void>>(
                new BaseResponse<Void>(ResultCode.SUCCESS.name(),
                        null,
                        memberService.signUp(memberDto)),
                HttpStatus.CREATED);
    }

    @PostMapping("/api/login")
    public ResponseEntity<BaseResponse<Void>> login(@RequestBody @Valid MemberLoginDto memberLoginDto) {
        return new ResponseEntity<>(new BaseResponse<Void>(
                ResultCode.SUCCESS.name(),
                null,
                memberService.login(memberLoginDto)),
                HttpStatus.OK) ;
    }
}
