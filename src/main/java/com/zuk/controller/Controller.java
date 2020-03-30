package com.zuk.controller;

import com.zuk.entity.User;
import com.zuk.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {
    UserServiceImpl userService = new UserServiceImpl();

    @RequestMapping("/")
    @ResponseBody
    String main() {
        return "Hello from Controller";
    }

    @RequestMapping("/loginForm")
    @ResponseBody
    ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("loginForm.html");
        return modelAndView;
    }

    @RequestMapping("/registrationForm")
    @ResponseBody
    ModelAndView registrationForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registrationForm.html");
        return modelAndView;
    }

    @RequestMapping("/login")
    @ResponseBody
    String login(@RequestParam String login,@RequestParam String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        return userService.login(user);
    }

    @RequestMapping("/registration")
    @ResponseBody
    String registration(@RequestParam String name,@RequestParam String surname, @RequestParam String login,@RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setPassword(password);
        return userService.registration(user);
    }
}
