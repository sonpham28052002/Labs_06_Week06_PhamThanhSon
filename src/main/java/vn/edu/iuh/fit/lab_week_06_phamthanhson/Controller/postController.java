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
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.Post;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.User;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.PostCommentRepository;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.PostRepository;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.UserRepository;

import java.time.LocalDate;


@Controller
@RequestMapping("/post")
public class postController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;
    @GetMapping("/list")
    public String getAll(Model model,HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("user"));
        model.addAttribute("posts",postRepository.findAll());
        return "listpost";
    }
    @GetMapping("/addPost")
    public ModelAndView add(){
        ModelAndView modelAndView = new ModelAndView();
        Post post = new Post();
        modelAndView.addObject("newPost", post);
        modelAndView.setViewName("addPost");
        return modelAndView;
    }
    @GetMapping("/addNewPost")
    public String addNewPost(@ModelAttribute Post post, HttpServletRequest request,Model model){
        User user = (User) request.getSession().getAttribute("user");

        ModelAndView modelAndView = new ModelAndView();
        Post post1 = Post.builder()
                .content(post.getContent())
                        .summary(post.getSummary())
                                .title(post.getTitle())
                                        .meta_title(post.getMeta_title())
                                                .createAt(LocalDate.now())
                                                        .published(true)
                                                                .publishAt(LocalDate.now())
                                                                        .user(user).build();
        System.out.println(post);
        postRepository.save(post1);
        model.addAttribute("posts",postRepository.findAll());
        return "listpost";
    }
}
