package com.leyou.item.service.impl;

import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author HackerStar
 * @create 2020-06-15 11:52
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {
    @Autowired
    private SpecGroupMapper groupMapper;
    @Autowired
    private SpecParamMapper paramMapper;

    /**
     * 根据分类id查询分组
     * @param cid
     * @return
     */
    @Override
    public List<SpecGroup> queryGroupsByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        return this.groupMapper.select(specGroup);
    }

    @Override
    public List<SpecParam> queryParams(Long gid,Long cid, Boolean generic, Boolean searching) {
        SpecParam record = new SpecParam();
        record.setGroupId(gid);
        record.setCid(cid);
        record.setGeneric(generic);
        record.setSearching(searching);
        return this.paramMapper.select(record);
    }

    @Override
    public List<SpecGroup> queryGroupsWithParam(Long cid) {
        // 查询规格组
        List<SpecGroup> groups = this.queryGroupsByCid(cid);
        groups.forEach(group ->{
            // 查询组内参数
            List<SpecParam> params = this.queryParams(group.getId(), null, null, null);
            group.setParams(params);
        });
        return groups;
    }
}
