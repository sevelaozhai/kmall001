package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("产品商品图片实体类")
public class PmsSkuImage  implements Serializable {
    @ApiModelProperty("产品商品图片编号")
    private Long id;
    @ApiModelProperty("产品商品图片编号")
    private Long skuId;
    @ApiModelProperty("产品商品图片名称")
    private String imgName;
    @ApiModelProperty("产品商品图片地址")
    private String imgUrl;
    @ApiModelProperty("平台商品图片编号")
    private Long spuImgId;
    @ApiModelProperty("是否默认")
    private String isDefault;

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

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Long getSpuImgId() {
        return spuImgId;
    }

    public void setSpuImgId(Long spuImgId) {
        this.spuImgId = spuImgId;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }
}