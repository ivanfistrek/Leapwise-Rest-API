package com.example.demo.interfaces;

import com.example.demo.entities.RSSFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotTopicsRepository extends JpaRepository<RSSFeed, Long> {
}
