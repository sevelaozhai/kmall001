package com.kgc.kmall.manager.controller;

import com.kgc.kmall.bean.PmsBaseAttrInfo;
import com.kgc.kmall.bean.PmsBaseAttrValue;
import com.kgc.kmall.service.AttrService;
import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AttrController {
    @Reference
    AttrService attrService;


    @RequestMapping("/attrInfoList")

    public List<PmsBaseAttrInfo>attrInfoList(Long catalog3Id){
        List<PmsBaseAttrInfo> infoList = attrService.select(catalog3Id);
        return infoList;
    }

    @RequestMapping("/saveAttrInfo")
    public Integer saveAttrInfo(@RequestBody PmsBaseAttrInfo attrInfo){
        Integer i = attrService.add(attrInfo);
        return i;
    }
    @RequestMapping("/getAttrValueList")
    public List<PmsBaseAttrValue> getAttrValueList(Long attrId){
        List<PmsBaseAttrValue> valueList = attrService.getAttrValueList(attrId);
        return valueList;
    }
}
