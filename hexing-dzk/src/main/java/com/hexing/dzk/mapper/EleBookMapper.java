package com.hexing.dzk.mapper;

import com.hexing.dzk.domain.BookAttach;
import com.hexing.dzk.domain.EleBook;

import java.util.List;

/**
 * @author hexing
 */
public interface EleBookMapper {


    /**
     * @param eleBook
     * @return
     */
    List<EleBook> getEleBookList(EleBook eleBook);

    EleBook searchById(long id);

    int updateBook(EleBook eleBook);

    /**
     * 批量删除
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteBookByIds(Long[] ids);

    int insertEleBook(EleBook eleBook);

    /*--------------分割线 -----------------------*/

    List<BookAttach> getAttachListById(BookAttach bookAttach);

    int updateAttach(BookAttach bookAttach);

    int deleteAttachByIds(Long[] ids);

    int insertBookAttach(BookAttach bookAttach);

    BookAttach searchAttachById(long id);
}
