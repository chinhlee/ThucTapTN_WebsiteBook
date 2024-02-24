package hunre.chinh.webbook.controller;

import hunre.chinh.webbook.dto.UserDto;
import hunre.chinh.webbook.entity.User;
import hunre.chinh.webbook.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthController {
  private UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/index")
  public String home() {
    return "index";
  }

  @GetMapping("/login")
  public String login(){
    return "login";
  }

  @GetMapping("/home_admin")
  public String homeadmin(){
    return "home_admin";
  }

  @GetMapping("/register")
  public String showRegistrationForm(Model model) {
    // create model object to store form data
    UserDto user = new UserDto();
    model.addAttribute("user", user);
    return "register";
  }
  @PostMapping("/register/save")
  public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                             BindingResult result,
                             Model model){
    User existingUser = userService.findUserByEmail(userDto.getEmail());

    if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
      result.rejectValue("email", null,
          "There is already an account registered with the same email");
    }

    if(result.hasErrors()){
      model.addAttribute("user", userDto);
      return "/register";
    }

    userService.saveUser(userDto);
    return "redirect:/register?success";
  }

  @GetMapping("/available_users")
  public String users(Model model) {
    List<UserDto> users = userService.findAllUsers();
    model.addAttribute("users", users);
    return "users"; //muc 10
  }

}
