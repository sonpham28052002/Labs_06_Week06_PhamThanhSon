package vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.PostComment;
@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}