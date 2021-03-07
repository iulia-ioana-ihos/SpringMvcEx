package com.evozon.mvc.controller;

import com.evozon.mvc.model.UserDTO;
import com.evozon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsernames(Model model) {
        List<UserDTO> users = userService.findAll();
        model.addAttribute("users",users);
        model.addAttribute("displayUsername", true);
        return "users";
    }


    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public String getUserDetailsFull(@PathVariable(value="username") String username,
                                     @RequestParam(required = false, name = "display") String displayType,
                                     Model model) {
        UserDTO user = userService.findByUsername(username);
        model.addAttribute("user", user);
        if(user.getUsername() != null)
            model.addAttribute("displayUser", true);
        if(displayType != null && displayType.equals("full"))  {
            model.addAttribute("displayDetailsFull", true);
        }

        return "users";
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
