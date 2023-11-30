package vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.Post;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.PostComment;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT pm FROM PostComment pm WHERE pm.parentID.id = ?1")
    public List<PostComment> getCommentById(long id);
}