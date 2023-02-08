package com.hexing.dzk.service;

import com.hexing.dzk.domain.BookAttach;
import com.hexing.dzk.domain.EleBook;

import java.util.List;

/**
 * @author hexing
 */
public interface IBookService {

    /**
     * @return
     */
    List<EleBook> getBookList(EleBook eleBook);

    EleBook getById(long id);

    /**
     * 书刊状态修改
     *
     * @return
     */
    int changeStatus(EleBook eleBook);

    /**
     * 批量删除电子刊
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteBookByIds(String ids) throws Exception;


    int addEleBook(EleBook eleBook)throws Exception;

    int updateEleBook(EleBook eleBook);

    /*-------------------------- 分割线 ------------------------------*/

    List<BookAttach> getAttachListById(Long bookId);

    List<BookAttach> getBookAttachList(BookAttach bookAttach);

    int changeStatus(BookAttach bookAttach);

    int deleteAttachByIds(String ids) throws Exception;

    int addBookAttach(BookAttach bookAttach)throws Exception;

    BookAttach getAttachById(Long attachId);

    int updateBookAttach(BookAttach bookAttach);

}
