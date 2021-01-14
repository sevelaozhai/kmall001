package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("商品查询第一分类实体类")
public class PmsBaseCatalog1 implements Serializable{
    @ApiModelProperty("商品查询第一分类编号")
    private Integer id;
    @ApiModelProperty("商品查询第一分类属性名称")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}