package com.anhtm.ordersfood.controller;

import com.anhtm.ordersfood.config.jwt.JwtTokenProvider;
import com.anhtm.ordersfood.dto.LogAppDto;
import com.anhtm.ordersfood.service.UserService;
import com.anhtm.ordersfood.utils.ResponseUtils;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Tag(name = "Log application Controller", description = "REST Apis get token.")
@RestController
@RequestMapping("api/public")
@CrossOrigin(origins = "http://localhost:4200")
public class LogAppController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login", consumes = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity <?> authenticateUser (@RequestBody LogAppDto loginRequest,
                                                HttpServletResponse response) {

        ResponseEntity <Object> re = userService.findUser(loginRequest);
        if (re.getStatusCodeValue() != HttpStatus.OK.value()) {
            return re;
        }

//        ResponseBodyDto bodyDto = (ResponseBodyDto) userService.findUser(loginRequest).getBody();
//        assert bodyDto != null;
//        UserDto userDto = (UserDto) bodyDto.getData();


        String token = jwtTokenProvider.getJWTToken(loginRequest.getUsername());
        response.setHeader("Authorization", token);
        return ResponseUtils.response(null, "Completed", HttpStatus.OK);
    }
}
