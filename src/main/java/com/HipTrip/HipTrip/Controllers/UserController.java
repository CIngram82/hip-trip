//package com.HipTrip.HipTrip.Controllers;
//
//import com.HipTrip.HipTrip.models.DataBase.User;
//import com.HipTrip.HipTrip.repository.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpSession;
//
//@RestController
//public class UserController {
//
//  @Autowired
//  UserRepo usersRepo;
//
//  @CrossOrigin
//  @GetMapping("/")
//  public String landingPage(HttpSession session){
//    if (session.getAttribute("current_user") == null) {
//      return "login";
//    }
//    return "index"; // Used with thymleaf
//  }
//
//  @CrossOrigin
//  @PostMapping("/login")
//  public String loginUser(User submittedUser, HttpSession session) {
//    User u = usersRepo
//        .findByNameAndPassword(submittedUser.getName(), submittedUser.getPassword());
//
//    if (u != null)
//      session.setAttribute("current_user", u.getId());
//
//    return "redirect:/"; // Used with thymleaf
//  }
//
//  @CrossOrigin
//  @GetMapping("/CreateAccount")
//  public String createUser(HttpSession session){
//    if (session.getAttribute("current_user") != null) {
//      return "redirect:/";
//    } else {
//      return "redirect:/AddUser";
//    }
//  }
//
//  @CrossOrigin
//  @PostMapping("/AddUser")
//  public String addUser(User submittedUser, HttpSession session){
//    if( submittedUser.getName() != null && submittedUser.getPassword() != null) {
//      usersRepo.save(submittedUser);
//      User u = usersRepo
//          .findByNameAndPassword(submittedUser.getName(), submittedUser.getPassword());
//
//      session.setAttribute("current_user", u.getId());
//      return "redirect:/";
//    }
//    return "redirect:/error";
//  }
//
//}
