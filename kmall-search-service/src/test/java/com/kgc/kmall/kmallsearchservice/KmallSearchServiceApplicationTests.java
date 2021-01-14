package com.kgc.kmall.kmallsearchservice;

import com.kgc.kmall.bean.PmsSearchSkuInfo;
import com.kgc.kmall.bean.PmsSkuInfo;
import com.kgc.kmall.service.SkuService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.dubbo.config.annotation.Reference;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class KmallSearchServiceApplicationTests {
	@Reference
	SkuService skuService;

	@Resource
	JestClient jestClient;

	@Test
	void contextLoads() {
		List<PmsSkuInfo> allSku = skuService.getAllSku();
		List<PmsSearchSkuInfo> pmsSearchSkuInfos=new ArrayList<>();
		for (PmsSkuInfo pmsSkuInfo : allSku) {
			PmsSearchSkuInfo pmsSearchSkuInfo = new PmsSearchSkuInfo();
			BeanUtils.copyProperties(pmsSkuInfo,pmsSearchSkuInfo);
			pmsSearchSkuInfo.setProductId(pmsSkuInfo.getSpuId());
			pmsSearchSkuInfos.add(pmsSearchSkuInfo);
		}
		for (PmsSearchSkuInfo pmsSearchSkuInfo : pmsSearchSkuInfos) {
			Index index=new Index.Builder(pmsSearchSkuInfo).index("kmall").type("PmsSkuInfo").id(pmsSearchSkuInfo.getId()+"").build();
			try {
				jestClient.execute(index);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	@Test
	void contextLoads2() {
		String json="{\n" +
				"  \"query\": {\n" +
				"    \"range\": {\n" +
				"      \"price\": {\n" +
				"        \"gte\": 4000,\n" +
				"        \"lte\": 5000\n" +
				"      }\n" +
				"    }\n" +
				"  }\n" +
				"}\n";
		Search search=new Search.Builder(json).addIndex("kmall").addType("PmsSkuInfo").build();
		try{
			SearchResult searchResult=jestClient.execute(search);
			List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = searchResult.getHits(PmsSearchSkuInfo.class);
			for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
				PmsSearchSkuInfo pmsSearchSkuInfo=hit.source;
				System.out.println(pmsSearchSkuInfo);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	@Test
	void contextLoads3() {
	//bool
		BoolQueryBuilder boolQueryBuilder=new BoolQueryBuilder();
		TermQueryBuilder termQueryBuilder=new TermQueryBuilder("skuAttrValueList.valueId",39);
		TermQueryBuilder termQueryBuilder2=new TermQueryBuilder("skuAttrValueList.valueId",43);

		boolQueryBuilder.filter(termQueryBuilder);
		boolQueryBuilder.filter(termQueryBuilder2);

		MatchQueryBuilder matchQueryBuilder=new MatchQueryBuilder("skuName","渐变真不错");
		boolQueryBuilder.must(matchQueryBuilder);

		SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
		//query
		searchSourceBuilder.query(boolQueryBuilder);
		//排序
		searchSourceBuilder.sort("id", SortOrder.DESC);
		System.out.println(searchSourceBuilder.toString());

		Search search=new Search.Builder(searchSourceBuilder.toString()).addIndex("kmall").addType("PmsSkuInfo").build();
		try{
			SearchResult searchResult=jestClient.execute(search);
			List<SearchResult.Hit<PmsSearchSkuInfo, Void>> hits = searchResult.getHits(PmsSearchSkuInfo.class);
			for (SearchResult.Hit<PmsSearchSkuInfo, Void> hit : hits) {
				PmsSearchSkuInfo pmsSearchSkuInfo=hit.source;
				System.out.println(pmsSearchSkuInfo.toString());
			}
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	@Test
	void contextLoads4() {

	}
	}


