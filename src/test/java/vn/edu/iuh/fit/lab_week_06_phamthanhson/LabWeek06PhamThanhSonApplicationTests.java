package vn.edu.iuh.fit.lab_week_06_phamthanhson;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.PostComment;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes.PostRepository;

@SpringBootTest
class LabWeek06PhamThanhSonApplicationTests {

    @Autowired
    private PostRepository postRepository;
    @Test
    void contextLoads() {
        System.out.println("sd");
        long id =1;
        for (PostComment postComment: postRepository.findById(id).get().getPostComments().get(0).getPostCommentList()) {
            System.out.println(postComment);
        }
    }

}
