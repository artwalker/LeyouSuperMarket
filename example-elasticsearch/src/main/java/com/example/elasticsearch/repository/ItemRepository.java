package com.example.elasticsearch.repository;

import com.example.elasticsearch.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-18 21:12
 */
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

    /**
     * 根据价格区间查询
     * @param price1
     * @param price2
     * @return
     */
    List<Item> findByPriceBetween(double price1, double price2);
}
