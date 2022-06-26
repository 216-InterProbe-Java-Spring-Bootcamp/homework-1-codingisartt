package com.tubanurbalci.userproductproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENT_PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommentProduct {
    @Id
    @GeneratedValue(generator = "commentProduct",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "commentProduct", sequenceName = "COMMENT_PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "Comment",length = 500)
    private String comment;

    @Column(name = "Comment_Date")
    @Temporal(TemporalType.DATE)
    private Date commentDate;

    @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                optional = false
    )
    @JoinColumn(name = "PRODUCT_ID",foreignKey = @ForeignKey(name = "FK_COMMENT_PRODUCT_PRODUCT"),nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY,
                cascade = CascadeType.ALL,
                optional = false)
    @JoinColumn(name = "USER_ID",foreignKey = @ForeignKey(name = "FK_COMMENT_PRODUCT_USER"))
    //@JsonIgnore
    private User user;

}
