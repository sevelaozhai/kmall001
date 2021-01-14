package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("商品基本属性值实体类")
public class PmsBaseAttrValue implements Serializable{
    @ApiModelProperty("商品基本属性值编号")
    private Long id;
    @ApiModelProperty("商品基本属性值名称")
    private String valueName;
    @ApiModelProperty("商品基本属性类编号")
    private Long attrId;
    @ApiModelProperty("商品基本属性值是否启用状态")
    private String isEnabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName == null ? null : valueName.trim();
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(String isEnabled) {
        this.isEnabled = isEnabled == null ? null : isEnabled.trim();
    }
}