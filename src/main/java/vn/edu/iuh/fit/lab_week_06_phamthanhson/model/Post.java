package vn.edu.iuh.fit.lab_week_06_phamthanhson.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "post")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"id"})
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    @JoinColumn(name = "author_Id")
    private User user;

    @OneToOne
    @JoinColumn(name = "parent_Id")
    private Post Parent_Id;

    @Column
    private String title;

    @Column
    private String meta_title;

    @Column
    private String summary;

    @Column
    private boolean published;
    @Column
    private LocalDate createAt;
    @Column
    private LocalDate updateAt;
    @Column
    private LocalDate publishAt;
    @Column
    private String content;

    @OneToMany(mappedBy = "post", fetch =  FetchType.EAGER)
    private List<PostComment> postComments;
}
