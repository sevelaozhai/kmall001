package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("商品查询第二分类实体类")
public class PmsBaseCatalog2 implements Serializable{
    @ApiModelProperty("商品查询第二分类编号")
    private Integer id;
    @ApiModelProperty("商品查询第二分类属性名称")
    private String name;
    @ApiModelProperty("商品查询第一分类类编号")
    private Integer catalog1Id;

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

    public Integer getCatalog1Id() {
        return catalog1Id;
    }

    public void setCatalog1Id(Integer catalog1Id) {
        this.catalog1Id = catalog1Id;
    }
}