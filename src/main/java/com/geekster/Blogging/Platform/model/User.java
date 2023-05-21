package com.geekster.Blogging.Platform.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = User.class,property = "userId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String firstname;
    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String Email;

    @Column(nullable = false)
    private String password;

    // Define relationships
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;


}
