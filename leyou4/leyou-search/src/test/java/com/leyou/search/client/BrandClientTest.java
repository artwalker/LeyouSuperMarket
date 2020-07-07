package com.leyou.search.client;

import com.leyou.LeYouSearchServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-20 10:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LeYouSearchServiceApplication.class)
public class BrandClientTest {
    @Autowired
    private CategoryClient categoryClient;
    @Autowired
    private BrandClient brandClient;

    @Test
    public void testQueryBrands() {
        List<String> names = this.categoryClient.queryNamesByIds(Arrays.asList(1L, 2L, 3L));
        names.forEach(name -> {
            System.out.println(name);
        });
//        Brand brand = brandClient.queryBrandById((long)8557);
//        System.out.println(brand);
    }
}
