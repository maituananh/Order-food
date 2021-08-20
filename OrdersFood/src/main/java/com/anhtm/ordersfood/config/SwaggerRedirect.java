package com.anhtm.ordersfood.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SwaggerRedirect {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView method() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("redirect:");
        stringBuilder.append("/swagger-ui.html");
        return new ModelAndView(stringBuilder.toString());
    }
}
