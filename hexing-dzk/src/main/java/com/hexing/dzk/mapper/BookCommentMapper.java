package com.hexing.dzk.mapper;
import java.util.Date;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.hexing.dzk.domain.BookComment;

public interface BookCommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookComment record);

    int insertSelective(BookComment record);

    BookComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookComment record);

    int updateByPrimaryKey(BookComment record);

    List<BookComment> selectAllByBookId(@Param("bookId")Integer bookId);

    Integer countByBookId(@Param("bookId")Integer bookId);

    List<BookComment> selectByAll(BookComment bookComment);

}