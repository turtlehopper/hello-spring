package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");  // MVC M model임.
        return "hello";     // model의 데이터 값이 hello!!의 값을 가지고 hello.html에 넘기라는 의미(랜더링)
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody  // http 통신 응답 body부에 직접 이 data를 적재해 주겠다. http 통신에서 사용하는 데이터 통신 방식!![비효율적]
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; // "hello (내가 바꾸는 단어로 배치)"
    }

    @GetMapping("hello-api")  // api 방식 JSON 방식으로 data를 넘긴다. [기본 방식]
    @ResponseBody  // HttpMessageConverter 작동.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        // Getter,Setter Java bean규약/ 프로퍼티 방식
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
