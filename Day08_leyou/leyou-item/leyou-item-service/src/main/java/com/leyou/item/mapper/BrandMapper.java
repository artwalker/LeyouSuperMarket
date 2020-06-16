package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author HackerStar
 * @create 2020-06-09 22:56
 */
public interface BrandMapper extends Mapper<Brand> {
    /**
     * 新增商品分类和品牌中间表数据
     * @param cid
     * @param bid
     */
    @Insert("insert into tb_category_brand(brand_id, category_id) values(#{cid},#{bid})")
    void insertCategoryAndBrand(@Param("cid") Long cid, @Param("bid") Long bid);
}
