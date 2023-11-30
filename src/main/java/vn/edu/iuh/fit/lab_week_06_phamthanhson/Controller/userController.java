package vn.edu.iuh.fit.lab_week_06_phamthanhson.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.User;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.PostRepository;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.UserRepository;

import java.time.LocalDate;

@Controller
@RequestMapping("/user")
public class userController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/login")
    public String loginUser(@ModelAttribute User user , HttpServletRequest request,Model model){
        System.out.println(user.getEmail());
        System.out.println(user.getPasswordHash());
         User user1=userRepository.getUserByEmailAndPasswordHash(user.getEmail(),user.getPasswordHash());
        System.out.println(user1);
        HttpSession session = request.getSession();
        session.setAttribute("user",user1);
        model.addAttribute("posts",postRepository.findAll());

        return "listpost";
    }
    @GetMapping("/signup")
    public ModelAndView signup(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("signup");
        return modelAndView;
    }
    @GetMapping("/signupNewUser")
    public String signup(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        User user1 = User.builder().firstName(user.getFirstName())
                        .lastName(user.getLastName())
                                .middleName(user.getMiddleName())
                                        .mobile(user.getMobile())
                                                .email(user.getEmail())
                                                        .passwordHash(user.getPasswordHash())
                                                                .registeredAt(LocalDate.now())
                                                                        .lastLogin(LocalDate.now())
                                                                                .intro(user.getIntro())
                                                                                        .profile(user.getProfile()).build();
        userRepository.save(user1);
        modelAndView.addObject("user",user);
        modelAndView.setViewName("signup");
        return "index";
    }
}
