package vn.edu.iuh.fit.lab_week_06_phamthanhson.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"id"})
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String middleName;
    @Column
    private String mobile;
    @Column
    private String email;
    @Column
    private String passwordHash;
    @Column
    private LocalDate registeredAt;
    @Column
    private LocalDate lastLogin;
    @Column
    private String intro;

    @Column
    private String profile;

}
