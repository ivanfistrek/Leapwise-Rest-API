package com.example.demo.interfaces;

import com.example.demo.entities.RSSFeed;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RSSFeedRepository extends CrudRepository<RSSFeed, Long> {

    List<RSSFeed> findByGuid(Long guid);

    RSSFeed findById(long guid);
}
