package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
@ApiModel("商品基本属性实体类")
public class PmsBaseAttrInfo implements Serializable{
    @ApiModelProperty("商品基本属性编号")
    private Long id;
    @ApiModelProperty("商品基本属性名称")
    private String attrName;
    @ApiModelProperty("商品基本属性的第三分类类编号")
    private Long catalog3Id;
    @ApiModelProperty("商品基本属性是否启用状态")
    private String isEnabled;

    private List<PmsBaseAttrValue> attrValueList;

    public List<PmsBaseAttrValue> getAttrValueList() {
        return attrValueList;
    }

    public void setAttrValueList(List<PmsBaseAttrValue> attrValueList) {
        this.attrValueList = attrValueList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public Long getCatalog3Id() {
        return catalog3Id;
    }

    public void setCatalog3Id(Long catalog3Id) {
        this.catalog3Id = catalog3Id;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled == null ? null : isEnabled.trim();
    }
}