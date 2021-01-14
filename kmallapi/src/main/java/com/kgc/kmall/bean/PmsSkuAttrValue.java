package com.kgc.kmall.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
@ApiModel("产品商品销售属性值关系实体类")
public class PmsSkuAttrValue  implements Serializable {
    @ApiModelProperty("产品商品销售属性值编号")
    private Long id;
    @ApiModelProperty("平台商品销售属性类编号")
    private Long attrId;
    @ApiModelProperty("平台商品销售属性值类编号")
    private Long valueId;
    @ApiModelProperty("产品商品销售属性类编号")
    private Long skuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }
}