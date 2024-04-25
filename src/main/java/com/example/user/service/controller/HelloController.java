package com.example.user.service.controller;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping(path = "/api") //localhost:8080/api/hello
public class HelloController {

    /*
    @GetMapping / @PostMapping / @qPutMapping / @DeleteMapping
    */

    @GetMapping("/hello")
    @RequestMapping(path = "/hello", method = RequestMethod.GET )
    public String sayHello(){
        return "Hello World!";
    }

    @GetMapping("/message/{message}")
    public String getMyMessage(@PathVariable String message){
        return "Mesajınız:" + message + "Kaydedilmiştir";
    }

    @GetMapping("/message")
    public String getMyMessage2(@RequestParam("m") String message) {
        return "Mesajınız:" + message + "Kaydedilmiştir";
    }

    @GetMapping({"/message1","/message1/{message}"})
    public String deneme(@PathVariable(name = "message",required = false) String message) {
        return "Mesajınız:" + message + "Kaydedilmiştir";
        //  required, eğer boş bırakılırsa null dönmesini sağlıyor
    }

    @GetMapping("/message2")
    public String deneme2(@RequestParam(name = "message",required = false,defaultValue = "Lütfen Bir Değer Girin!") String message) {
        return "Mesajınız:" + message + "Kaydedilmiştir";
    }

    @GetMapping("/header")
    public String getHeader(@RequestHeader("My-Header") String myHeader){
        return "Your Header is" +myHeader;
    }


}
