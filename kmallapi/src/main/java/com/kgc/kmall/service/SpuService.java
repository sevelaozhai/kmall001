package com.kgc.kmall.service;

import com.kgc.kmall.bean.PmsBaseSaleAttr;
import com.kgc.kmall.bean.PmsProductImage;
import com.kgc.kmall.bean.PmsProductInfo;
import com.kgc.kmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    public List<PmsProductInfo> spuList(Long catalog3Id);

    public List<PmsBaseSaleAttr> baseSaleAttrList();
//保存数据库
    public Integer saveSpuInfo(PmsProductInfo pmsProductInfo);
//根据spuid查询销售属性
    List<PmsProductSaleAttr> spuSaleAttrList(Long spuId);
//根据spuid查询图片
    List<PmsProductImage> spuImageList(Long spuId);

    List<PmsProductSaleAttr> spuSaleAttrListIsCheck(Long spuId,Long skuId);
}
