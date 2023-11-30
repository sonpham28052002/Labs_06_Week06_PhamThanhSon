package vn.edu.iuh.fit.lab_week_06_phamthanhson.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.Post;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.PostComment;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.User;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.PostCommentRepository;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.PostRepository;

import java.time.LocalDate;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private PostCommentRepository postCommentRepository;

    @Autowired
    private PostRepository postRepository;
    @PostMapping("/insert")
    public String insert(HttpServletRequest request , Model model){

        User user = (User)request.getSession().getAttribute("user");
        System.out.println(user);
        long post_id = Long.parseLong(request.getParameter("post_id"));
        Post post = postRepository.findById(post_id).get();
        if (request.getParameter("id")==null){
            PostComment postComment = PostComment.builder()
                    .post(post)
                    .publishAt(LocalDate.now())
                    .published(true)
                    .title("")
                    .content(request.getParameter("comment"))
                    .user(user)
                    .createAt(LocalDate.now())
                    .parentID(null).build();
            postCommentRepository.save(postComment);
        }else {
            long comment_id = Long.parseLong(request.getParameter("id"));
            PostComment postComment = PostComment.builder()
                    .post(post)
                    .publishAt(LocalDate.now())
                    .published(true)
                    .title("")
                    .content(request.getParameter("comment"))
                    .user(user)
                    .createAt(LocalDate.now())
                    .parentID(postCommentRepository.findById(comment_id).get()).build();
            postCommentRepository.save(postComment);
        }

        model.addAttribute("posts",postRepository.findAll());

        return "listpost";
    }

}
