package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
@ApiModel("平台商品销售属性值实体类")
public class PmsProductSaleAttrValue implements Serializable {
    @ApiModelProperty("平台商品销售属性值编号")
    private Long id;
    @ApiModelProperty("平台商品属性类编号")
    private Long productId;
    @ApiModelProperty("平台商品销售属性类编号")
    private Long saleAttrId;
    @ApiModelProperty("平台商品销售属性值名称")
    private String saleAttrValueName;

    private Long isChecked;

    public Long getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Long isChecked) {
        this.isChecked = isChecked;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(Long saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public String getSaleAttrValueName() {
        return saleAttrValueName;
    }

    public void setSaleAttrValueName(String saleAttrValueName) {
        this.saleAttrValueName = saleAttrValueName == null ? null : saleAttrValueName.trim();
    }
}