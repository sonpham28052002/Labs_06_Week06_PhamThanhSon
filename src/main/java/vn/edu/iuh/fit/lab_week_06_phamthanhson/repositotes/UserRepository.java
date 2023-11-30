package vn.edu.iuh.fit.lab_week_06_phamthanhson.repositotes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab_week_06_phamthanhson.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User getUserByEmailAndPasswordHash(String email,String PasswordHash);
}