package com.tubanurbalci.userproductproject.repository;
import com.tubanurbalci.userproductproject.entity.CommentProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface CommentRepository extends JpaRepository<CommentProduct,Long> {


    List<CommentProduct> findAllByProduct_Id(Long productId);

    List<CommentProduct> findAllByProduct_IdAndCommentDateBetween(Long productId, Date first, Date second);

    List<CommentProduct> findAllByUser_Id(Long userId);

    List<CommentProduct> findAllByUser_IdAndCommentDateBetween(Long userId,Date first, Date second);


}
