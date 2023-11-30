package vn.edu.iuh.fit.lab_week_06_phamthanhson.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "postcomment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(exclude = {"id"})

public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "prarent_id")
    private PostComment parentID;

    @OneToMany(mappedBy = "parentID",fetch = FetchType.EAGER)
    private List<PostComment> postCommentList;

    @Column
    private String title;

    @Column
    private boolean published;

    @Column
    private LocalDate createAt;
    @Column
    private LocalDate publishAt;
    @Column
    private String content;

    @ManyToOne
    private User user;
    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", parentID=" + parentID +
                ", title='" + title + '\'' +
                ", published=" + published +
                ", createAt=" + createAt +
                ", publishAt=" + publishAt +
                ", content='" + content + '\'' +
                '}';
    }
}
