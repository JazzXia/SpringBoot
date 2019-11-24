package com.qtatelier.elasticsearch;

import com.qtatelier.elasticsearch.bean.Book;
import com.qtatelier.elasticsearch.repository.BookRespository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class Springboot03ElasticsearchApplicationTests {

    @Resource
    BookRespository bookRespository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testData(){
/*        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRespository.index(book);*/


        for (Book book :bookRespository.findByBookNameLike("游")){
            System.out.println(book);
             
        }
    }


}
