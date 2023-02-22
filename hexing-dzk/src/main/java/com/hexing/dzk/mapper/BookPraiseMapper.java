package com.hexing.dzk.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.hexing.dzk.domain.BookPraise;

public interface BookPraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookPraise record);

    int insertSelective(BookPraise record);

    BookPraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookPraise record);

    int updateByPrimaryKey(BookPraise record);


    Integer countByBookId(@Param("bookId")Integer bookId);

    List<BookPraise> selectByUserIdAndBookId(@Param("userId")Long userId,@Param("bookId")Integer bookId);


    int deleteByBookIdAndUserId(@Param("userId")Long userId,@Param("bookId")Integer bookId);



}