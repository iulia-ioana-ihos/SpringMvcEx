package com.evozon.mvc.controller;

import com.evozon.entity.User;
import com.evozon.mvc.model.UserDTO;
import com.evozon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegistration(@ModelAttribute("user") UserDTO registration) {
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String addRegistration(@ModelAttribute("user") UserDTO user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
