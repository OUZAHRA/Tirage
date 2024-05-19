package com.tirage.examen.Controller;

import com.tirage.examen.Service.UserService;
import com.tirage.examen.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin_home";
    }


    @GetMapping("/admin/all_user")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "all_user";
    }

    @GetMapping("/admin/create_user")
    public String createUserForm() {
        return "create_user";
    }

    @PostMapping("/admin/create_user")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/admin/all_user";
    }

    @GetMapping("/admin/edit_user")
    public String editUserForm() {
        return "edit_user";
    }

    @PostMapping("/admin/edit_user")
    public String editUser(User user) {
        userService.updateUser(user);
        return "redirect:/admin/all_user";
    }

    @GetMapping("/admin/delete_user")
    public String deleteUserForm() {
        return "delete_user";
    }

    @PostMapping("/admin/delete_user")
    public String deleteUser(Long userId) {
        userService.deleteUserById(userId);
        return "redirect:/admin/all_user";
    }
    @Autowired
    private UserService userService;

    public String getAdmin(){return "/admin/users";}



    @PostMapping("/user")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "all_user";
    }

    @GetMapping("/admin/user/new")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "create_user";
    }


    @GetMapping("/admin/user/edit/{id}")
    public String showEditUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit_user";
    }

    @PostMapping("/admin/user/update/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/admin/users";
    }


}
