package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrValue;

import java.util.List;
import java.util.Set;

public interface AttrService {
    //查询属性根据分类三id
    public List<PmsBaseAttrInfo>select (Long catalog3Id);
    //添加属性
    public Integer add(PmsBaseAttrInfo attrInfo);
    //根据属性id查询属性值
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId);

    List<PmsBaseAttrInfo> selectAttrInfoValueListByValueId(Set<Long> valueIds);
}
