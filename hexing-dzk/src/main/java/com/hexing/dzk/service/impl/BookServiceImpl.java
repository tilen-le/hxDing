package com.hexing.dzk.service.impl;

import com.hexing.common.core.text.Convert;
import com.hexing.dzk.domain.BookAttach;
import com.hexing.dzk.domain.EleBook;
import com.hexing.dzk.mapper.EleBookMapper;
import com.hexing.dzk.service.IBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hexing
 */
@Service
public class BookServiceImpl implements IBookService {

    @Resource
    private EleBookMapper eleBookMapper;

    @Override
    public List<EleBook> getBookList(EleBook eleBook) {
        //获取列表
        List<EleBook> eleBookList = eleBookMapper.getEleBookList(eleBook);
        return eleBookList;
    }

    @Override
    public EleBook getById(long id) {
        return eleBookMapper.searchById(id);
    }

    @Override
    public int changeStatus(EleBook eleBook) {
        return eleBookMapper.updateBook(eleBook);
    }

    @Override
    public int deleteBookByIds(String ids) throws Exception {
        Long[] bookIds = Convert.toLongArray(ids);
        return eleBookMapper.deleteBookByIds(bookIds);
    }

    @Override
    public int addEleBook(EleBook eleBook) throws Exception {
        return eleBookMapper.insertEleBook(eleBook);
    }

    @Override
    public int updateEleBook(EleBook eleBook) {
        return eleBookMapper.updateBook(eleBook);
    }

    @Override
    public List<BookAttach> getAttachListById(Long bookId) {
        BookAttach bookAttach = new BookAttach();
        bookAttach.setBookId(bookId);
        return eleBookMapper.getAttachListById(bookAttach);
    }

    @Override
    public List<BookAttach> getBookAttachList(BookAttach bookAttach) {
        return eleBookMapper.getAttachListById(bookAttach);
    }

    @Override
    public int changeStatus(BookAttach bookAttach) {
        return eleBookMapper.updateAttach(bookAttach);
    }

    @Override
    public int deleteAttachByIds(String ids) throws Exception {
        Long[] attachIds = Convert.toLongArray(ids);
        return eleBookMapper.deleteAttachByIds(attachIds);
    }

    @Override
    public int addBookAttach(BookAttach bookAttach) throws Exception {
        return eleBookMapper.insertBookAttach(bookAttach);
    }

    @Override
    public BookAttach getAttachById(Long attachId) {
        return eleBookMapper.searchAttachById(attachId);
    }

    @Override
    public int updateBookAttach(BookAttach bookAttach) {
        return eleBookMapper.updateAttach(bookAttach);
    }


}
