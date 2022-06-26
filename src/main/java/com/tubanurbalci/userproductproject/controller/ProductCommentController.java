package com.tubanurbalci.userproductproject.controller;

import com.tubanurbalci.userproductproject.entity.Product;
import com.tubanurbalci.userproductproject.entity.CommentProduct;
import com.tubanurbalci.userproductproject.repository.CommentRepository;

import com.tubanurbalci.userproductproject.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/productcomment")
public class ProductCommentController {
    //@Autowired
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    @PostMapping("/savecomment")
    public CommentProduct save(@RequestBody CommentProduct commentProduct){
        return commentRepository.save(commentProduct);
    }

    @PostMapping("/save_product")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }


    @GetMapping("/commentbyproduct/{id}")
    public List<CommentProduct> getAllCommentsForOneProduct(@PathVariable Long productId){
        return commentRepository.findAllByProduct_Id(productId);
    }

    @GetMapping("/commentbybetweendate/product/{id}/{first}/{second}")
    public List<CommentProduct> getAllCommentsProductandDate(@PathVariable Long productId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date first, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date second){
        return commentRepository.findAllByProduct_IdAndCommentDateBetween(productId,second,first);
    }

    @GetMapping("/commentbyuser/")
    public List<CommentProduct> getAllCommentsByUser_Id(@RequestParam Long userId){
        return commentRepository.findAllByUser_Id(userId);
    }

    @GetMapping("/commentbybetweendate/{userId}/{first}/{second}")
    public List<CommentProduct> getAllCommentsDateBetween(@PathVariable Long userId,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date first,@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date second){
        return commentRepository.findAllByUser_IdAndCommentDateBetween(userId,first,second);
    }

    @GetMapping("/productbybeforedate/{date}")
    public List<Product> getAllProductsBeforeExpirationDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return productRepository.findAllByExpirationDateLessThan(date);
    }

    @GetMapping("/productbyafterdate/{date}")
    public List<Product> getAllProductsAfterExpirationDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return productRepository.findAllByExpirationDateAfter(date);
    }

}
