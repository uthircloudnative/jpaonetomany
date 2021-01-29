package com.gmdb.jpaonetomany.unidirectionalentymapping.repository;

import com.gmdb.jpaonetomany.unidirectionalentymapping.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page,Long> {
}
