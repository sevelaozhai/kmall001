package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("商品基本销售实体类")
public class PmsBaseSaleAttr implements Serializable {
    @ApiModelProperty("商品基本销售编号")
    private Long id;
    @ApiModelProperty("商品基本销售名称")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}