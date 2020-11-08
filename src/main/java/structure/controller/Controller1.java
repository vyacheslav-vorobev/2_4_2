package structure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import structure.dao.UserDaoImp;
import structure.model.User;
import structure.service.UserService;

@Controller
@RequestMapping("/users")
public class Controller1 {

    UserService userService;
    @Autowired
    public Controller1(UserService userDao) {
        this.userService = userDao;
    }

    @GetMapping()
    public String viewsUsers(Model model){
        model.addAttribute("users", userService.listUsers());
        return "allUsers";
    }
    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id")Long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "user";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }
    @PostMapping()
    public String create(@ModelAttribute("user") User user){
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        userService.add(user);
        return "redirect:/users";
    }
}
