package pl.wb.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.wb.crud.entity.User;
import pl.wb.crud.service.UserService;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    // @Autowired is optional because we are using only one constructor!
    @Autowired
    // constructor injection
    public UserController (UserService userService) {
        this.userService = userService;
    }

    //add mapping for "/list"
    @GetMapping("/list")
    public String listUsers (Model theModel) {

        // get users from database
        List<User> theUsers = userService.findAll();

        // add to the spring model
        theModel.addAttribute("users", theUsers);
        return "users/list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){

        // create model attribute to bind form data
        User theUser = new User();

        theModel.addAttribute("user", theUser);

        return "users/users-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel){

        // get user from the service
        User theUser = userService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("user", theUser);

        // send over to our form
        return "users/users-form";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User theUser){

        // save the user
        userService.save(theUser);

        // use a redirect to prevent duplicate submissions  - "post/redirect/get" pattern
        return "redirect:/users/list";
    }

    @GetMapping("/delete")
    public String delete (@RequestParam("userId") int theId) {

        // delete user!
        userService.deleteById(theId);

        return "redirect:/users/list";
    }
}


// ------------------ for in memory usage ---------------
//@Controller
//@RequestMapping("/users")
//public class UserController {
//
//
//    //add mapping for "/list"
//    @GetMapping("/list")
//    public String listUsers (Model theModel) {
//
//        // add to the spring model
//        theModel.addAttribute("users", theUsers);
//        return "list-Users";
//    }

//    //load user data
//    private List<User> theUsers;
//
//    @PostConstruct
//    private void loadDate () {
//
//        //create users
//        User u1 = new User(1, "Karol", "Ogon", "ko@gmail.com", LocalDateTime.of(2019, Month.APRIL, 20, 2, 30));
//        User u2 = new User(2, "Karolina", "Oginski", "koginska@gmail.com", LocalDateTime.of(2020, Month.JANUARY, 01, 12, 16));
//        User u3 = new User(3, "Robert", "Kalarepa", "rk@gmail.com", LocalDateTime.of(2019, Month.NOVEMBER, 10, 21, 23));
//        User u4 = new User(4, "Maria", "Namyslowska", "mn@gmail.com", LocalDateTime.of(2014, Month.AUGUST, 12, 18, 52));
//
//        //create the list
//        theUsers = new ArrayList<>();
//
//        //add to the list
//        theUsers.add(u1);
//        theUsers.add(u2);
//        theUsers.add(u3);
//        theUsers.add(u4);
//    }
