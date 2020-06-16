package com.leyou.item.mapper;

import com.leyou.item.pojo.Category;
import tk.mybatis.mapper.additional.idlist.SelectByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author HackerStar
 * @create 2020-06-09 21:22
 */
public interface CategoryMapper extends Mapper<Category>, SelectByIdListMapper<Category, Long> {
}
