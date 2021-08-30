package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.dto.LogAppDto;
import com.anhtm.ordersfood.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/public")
public class LogAppController {
//    @Autowired
//    AuthenticationManager authenticationManager;

//    @Autowired
//    private JwtTokenProvider tokenProvider;

    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> authenticateUser(@RequestBody LogAppDto loginRequest) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//        System.out.println(authentication);
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Trả về jwt cho người dùng.
//        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        return new ResponseEntity <Object>(ResponseUtils.response(null, "Completed", HttpStatus.OK),
                HttpStatus.OK);
    }
}
