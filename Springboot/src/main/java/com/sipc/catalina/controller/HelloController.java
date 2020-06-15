package com.sipc.catalina.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@RestController //@RestController = @Controller + @ResponseBody
@Controller  //单独使用：如重定向
@ResponseBody
public class HelloController {

    @Autowired
    private TodoListConfig todoListConfig;

    @Value("${todo.date}") //使用application.yml中的自定义变量
    private String data;

//    @GetMapping("/hello")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say(){
        return "redirect:https://www.baidu.com";
    }

    @GetMapping({"/welcome", "/hi"})
    public String welcome(){
        return "index";
    }

    @GetMapping("/data")
    public String getData(){
        return "今天是" + data;
    }

    @GetMapping("/todo")
    public String getTodo(){
        return todoListConfig.getThing();
    }

    @GetMapping("/say") //localhost:8081/say?id=1
    public String say(@RequestParam("id") String id){
        return "学生的id是" + id;
    }

    @GetMapping("/say2/{id}") //http://localhost:8081/say2/2
    public String say2(@PathVariable("id") Integer id){
        return "学生的id是" + id;
    }

    @GetMapping("/say3") // 参数值可以不传
    public String say3(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id){
        return "学生的id是" + id;
    }
}
