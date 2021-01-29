package com.gmdb.jpaonetomany.unidirectionalentymapping.repository;

import com.gmdb.jpaonetomany.unidirectionalentymapping.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
