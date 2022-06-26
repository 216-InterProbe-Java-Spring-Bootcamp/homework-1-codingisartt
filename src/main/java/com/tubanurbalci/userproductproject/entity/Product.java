package com.tubanurbalci.userproductproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "PRODUCTS")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(generator = "product",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "product", sequenceName = "PRODUCT_ID_SEQ")
    private Long id;

    @Column(name = "Name",length = 50,nullable = false)
    private String name;

    @Column(name = "Price",precision = 15,scale = 2,nullable = false)
    private Double price;

    @Column(name = "Expiration_Date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;


    @OneToMany(cascade = CascadeType.ALL,
           fetch = FetchType.LAZY,
           mappedBy = "product")
    private Set<CommentProduct> commentProducts;

}
