package com.gmdb.jpaonetomany.unidirectionalentymapping;

import com.gmdb.jpaonetomany.unidirectionalentymapping.entity.Book;
import com.gmdb.jpaonetomany.unidirectionalentymapping.entity.Page;
import com.gmdb.jpaonetomany.unidirectionalentymapping.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class JpaUniOneToMapControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testCreateBook(){

        Book book = new Book("IntegTesting","JoshLong");

        Page page1 = new Page("How to do IntegTesting",Integer.valueOf("1"));
        Page page2 = new Page("How to do UnitTesting",Integer.valueOf("2"));

//        mockMvc.perform(post("/book").contentType(MediaType.APPLICATION_JSON)
//                        .content())
    }
}
