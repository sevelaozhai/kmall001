package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("产品商品销售属性值实体类")
public class PmsSkuSaleAttrValue  implements Serializable {
    @ApiModelProperty("产品商品销售属性值编号")
    private Long id;
    @ApiModelProperty("产品商品库存编号")
    private Long skuId;
    @ApiModelProperty("平台商品销售属性编号")
    private Long saleAttrId;
    @ApiModelProperty("平台商品销售属性值编号")
    private Long saleAttrValueId;
    @ApiModelProperty("平台商品销售属性名称")
    private String saleAttrName;
    @ApiModelProperty("平台商品销售属性值名称")
    private String saleAttrValueName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getSaleAttrId() {
        return saleAttrId;
    }

    public void setSaleAttrId(Long saleAttrId) {
        this.saleAttrId = saleAttrId;
    }

    public Long getSaleAttrValueId() {
        return saleAttrValueId;
    }

    public void setSaleAttrValueId(Long saleAttrValueId) {
        this.saleAttrValueId = saleAttrValueId;
    }

    public String getSaleAttrName() {
        return saleAttrName;
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName == null ? null : saleAttrName.trim();
    }

    public String getSaleAttrValueName() {
        return saleAttrValueName;
    }

    public void setSaleAttrValueName(String saleAttrValueName) {
        this.saleAttrValueName = saleAttrValueName == null ? null : saleAttrValueName.trim();
    }
}