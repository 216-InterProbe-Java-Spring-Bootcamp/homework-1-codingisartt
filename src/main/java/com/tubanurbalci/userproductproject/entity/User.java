package com.tubanurbalci.userproductproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "user", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "user", sequenceName = "USER_ID_SEQ")
    private Long id;

    @Column(name = "Name",length = 50,nullable = false)
    private String name;

    @Column(name = "Surname",length = 50,nullable = false)
    private String surname;

    @Email
    @Column(name = "Email",length = 50)
    private String email;

    @Column(name = "Telefon",length = 15)
    private String telefon;

    @JsonIgnore
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user"
    )
    private Set<CommentProduct> commentProducts;

}
