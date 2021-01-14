package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
@ApiModel("平台商品销售属性实体类")
public class PmsProductSaleAttr  implements Serializable {
    @ApiModelProperty("平台商品销售属性编号")
    private Long id;
    @ApiModelProperty("平台商品属性类编号")
    private Long productId;
    @ApiModelProperty("平台商品销售属性值类编号")
    private Long saleAttrId;
    @ApiModelProperty("平台商品销售属性名称")
    private String saleAttrName;
    private List<PmsProductSaleAttrValue> spuSaleAttrValueList;

    public List<PmsProductSaleAttrValue> getSpuSaleAttrValueList() {
        return spuSaleAttrValueList;
    }

    public void setSpuSaleAttrValueList(List<PmsProductSaleAttrValue> spuSaleAttrValueList) {
        this.spuSaleAttrValueList = spuSaleAttrValueList;
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

    public String getSaleAttrName() {
        return saleAttrName;
    }

    public void setSaleAttrName(String saleAttrName) {
        this.saleAttrName = saleAttrName == null ? null : saleAttrName.trim();
    }
}