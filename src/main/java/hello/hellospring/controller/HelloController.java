package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        // data라는 이름으로 hello!라는 value를 담아서 보냄
        model.addAttribute("data", "hello!");
        return "hello";

    }
}

// ctrl 누르고 return 값 누르면 연결된 곳 바로감
//