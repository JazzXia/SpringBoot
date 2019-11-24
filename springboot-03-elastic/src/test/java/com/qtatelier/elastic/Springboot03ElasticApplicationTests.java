package com.qtatelier.elastic;

import com.qtatelier.elastic.bean.Article;
import io.searchbox.client.JestClient;

import io.searchbox.client.JestResult;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Resource
    JestClient jestClient;

    @Test
    public void contextLoads() {
        //1、给Es中索引(保存)一个文档;
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("威爷");
        article.setContent("Hello World");

        //构建一个索引功能  注意点:index里面不能写大写!!!!否则返回是false
        Index index = new Index.Builder(article).index("jest").type("news").build();

        System.out.println(index);
         
        try {
            //执行
            JestResult jestResult = jestClient.execute(index);
            System.out.println("执行完成"+jestResult.isSucceeded());
             
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void testSearch(){

        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addIndex("jest").addType("news").build();


        try {
            //执行
            SearchResult searchResult = jestClient.execute(search);
            System.out.println(searchResult.getJsonString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
