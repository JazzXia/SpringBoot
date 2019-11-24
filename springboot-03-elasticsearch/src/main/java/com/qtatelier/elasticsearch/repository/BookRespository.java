package com.qtatelier.elasticsearch.repository;

import com.qtatelier.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author JazzXia
 * @create 2019-10-23-14:03
 * @email jazzxiaw@qq.com
 * @since 2019
 */
public interface BookRespository extends ElasticsearchRepository<Book,Integer> {

    public List<Book> findByBookNameLike(String bookName);
}
