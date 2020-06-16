package com.leyou.item.bo;

import com.leyou.item.pojo.Spu;

/**
 * @author HackerStar
 * @create 2020-06-15 16:00
 */
public class SpuBo extends Spu {
    String cname;// 商品分类名称

    String bname;// 品牌名称

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
