package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class DefaultController {
    @RequestMapping("/**")
    public String index(HttpServletRequest httpServletRequest) throws IOException {
        return "redirect:/api";
    }
}
