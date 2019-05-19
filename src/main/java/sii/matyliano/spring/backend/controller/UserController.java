package sii.matyliano.spring.backend.controller;//package sii.matyliano.spring.backend.controller;
//

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//
//import javax.validation.Valid;
//
//@Controller
//public class UserController {
//
//
//    private final UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @ModelAttribute("user")
//    public UserDto userRegistrationDto() {
//        return new UserDto();
//    }
//
//    @GetMapping
//    public String showRegistrationForm(Model model) {
//        return "registration";
//    }
//
//    @PostMapping
//    public String registerUserAccount(@ModelAttribute("user") @Valid UserDto userDto,
//                                      BindingResult result){
//
//        User existing = userService.findByEmail(userDto.getEmail());
//        if (existing != null){
//            result.rejectValue("email", null, "There is already an account registered with that email");
//        }
//
//        if (result.hasErrors()){
//            return "registration";
//        }
//
//        userService.save(userDto);
//        return "redirect:/registration?success";
//    }
//
//
//    //wiem, że nie tak ale jak to walnąć do vaadina, nie wiem
//    public String editUser(String email,Model model){
//        if(userService.findByEmail(email) != null){
//            model.addAttribute("editUser",userService.findByEmail(email));
//            return "userform";
//        }
//        return "redirect:/users";
//    }
//
//
//
//}
