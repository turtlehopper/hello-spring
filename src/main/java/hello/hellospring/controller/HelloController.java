package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");  // MVC M model임.
        return "hello";     // model의 데이터 값이 hello!!의 값을 가지고 hello.html에 넘기라는 의미(랜더링)
    }
}
