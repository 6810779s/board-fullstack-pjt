package board.pjt.back.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @GetMapping("/test")
    public String test(){
        System.out.println("test");
        return "ok";
    }
}
