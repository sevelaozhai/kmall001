package com.kgc.kmall.manager.service;

import com.alibaba.fastjson.JSON;
import com.kgc.kmall.bean.*;
import com.kgc.kmall.manager.mapper.PmsSkuAttrValueMapper;
import com.kgc.kmall.manager.mapper.PmsSkuImageMapper;
import com.kgc.kmall.manager.mapper.PmsSkuInfoMapper;
import com.kgc.kmall.manager.mapper.PmsSkuSaleAttrValueMapper;

import com.kgc.kmall.service.SkuService;
import com.kgc.kmall.utils.RedisUtil;
import org.apache.dubbo.config.annotation.Service;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.locks.Lock;


@Component
@Service
public class SkuServiceImpl implements SkuService {
    @Resource
    PmsSkuInfoMapper pmsSkuInfoMapper;
    @Resource
    PmsSkuImageMapper pmsSkuImageMapper;
    @Resource
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;
    @Resource
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;
    @Resource
    RedisUtil redisUtil;
    @Resource
    RedissonClient redissonClient;
    @Override
    public String saveSkuInfo(PmsSkuInfo skuInfo) {
        pmsSkuInfoMapper.insert(skuInfo);
        Long skuInfoId = skuInfo.getId();
        for (PmsSkuImage pmsSkuImage : skuInfo.getSkuImageList()) {
            pmsSkuImage.setSkuId(skuInfoId);
            pmsSkuImageMapper.insert(pmsSkuImage);
        }
        for (PmsSkuAttrValue pmsSkuAttrValue : skuInfo.getSkuAttrValueList()) {
            pmsSkuAttrValue.setSkuId(skuInfoId);
            pmsSkuAttrValueMapper.insert(pmsSkuAttrValue);
        }
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuInfo.getSkuSaleAttrValueList()) {
            pmsSkuSaleAttrValue.setSkuId(skuInfoId);
            pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
        }
        return "success";
    }
//    @Override
//    public PmsSkuInfo selectBySkuId(Long id) {
//        return pmsSkuInfoMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public List<PmsSkuInfo> selectBySpuId(Long spuId) {
//        return pmsSkuInfoMapper.selectBySpuId(spuId);
//    }

    @Override
    public List<PmsSkuInfo> selectBySpuId(Long spuId) {
        return pmsSkuInfoMapper.selectBySpuId(spuId);
    }

    @Override
    public List<PmsSkuInfo> getAllSku() {
        List<PmsSkuInfo>pmsSkuInfos=pmsSkuInfoMapper.selectByExample(null);
        for (PmsSkuInfo pmsSkuInfo : pmsSkuInfos) {
            PmsSkuAttrValueExample example=new PmsSkuAttrValueExample();
            PmsSkuAttrValueExample.Criteria criteria = example.createCriteria();
            criteria.andSkuIdEqualTo(pmsSkuInfo.getId());
            List<PmsSkuAttrValue> pmsSkuAttrValues = pmsSkuAttrValueMapper.selectByExample(example);
            pmsSkuInfo.setSkuAttrValueList(pmsSkuAttrValues);
        }
        return pmsSkuInfos;
    }

    //    @Override
//    public PmsSkuInfo selectBySkuId(Long id) {
//        Jedis jedis = redisUtil.getJedis();
//        String skuKey= "sku:"+id+":info";
//        String skuInfoJson = jedis.get(skuKey);
//        if(skuInfoJson!=null ){
//            PmsSkuInfo pmsSkuInfo = JSON.parseObject(skuInfoJson, PmsSkuInfo.class);
//            jedis.close();
//            return pmsSkuInfo;
//        }else{
//            PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectByPrimaryKey(id);
//            //保存到redis
//            String skuInfoJsonStr = JSON.toJSONString(pmsSkuInfo);
//            jedis.set(skuKey,skuInfoJsonStr);
//            return pmsSkuInfo;
//        }
//    }
//@Override
//public PmsSkuInfo selectBySkuId(Long id) {
//    PmsSkuInfo pmsSkuInfo=null;
//    Jedis jedis = redisUtil.getJedis();
//    String skuKey= "sku:"+id+":info";
//    String skuInfoJson = jedis.get(skuKey);
//    if(skuInfoJson==null){
//        //使用nx分布式锁，避免缓存击穿
//        String skuLockKey="sku:"+id+":lock";
//        String skuLockValue= UUID.randomUUID().toString();
//
//        Long lock=jedis.setnx(skuLockKey,skuLockValue);
//        //设置有效期
//        jedis.expire(skuLockKey,60);
//        if (lock!=null&&lock.equals("OK")){
//            pmsSkuInfo = pmsSkuInfoMapper.selectByPrimaryKey(id);
//            //防止缓存穿透，从DB中找不到数据也要缓存，但是缓存时间不要太长
//            if (pmsSkuInfo!=null){
//                //保存到redis
//                String skuInfoJsonStr = JSON.toJSONString(pmsSkuInfo);
//                //有效期随机，防止缓存雪崩
//                Random random=new Random();
//                int i = random.nextInt(10);
//                jedis.setex(skuKey,i*60*1000,skuInfoJsonStr);
//
//            }else{
//                jedis.setex(skuKey,5*60*1000, "empty");
//            }
//            //删除分布式锁
//            //解决思路是利用lua脚本在获得value后进行判断和删除
//            String script ="if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//            jedis.eval(script, Collections.singletonList(skuLockKey),Collections.singletonList(skuLockKey));
//        }else {
//            //如果分布式锁访问失败，线程休眠3秒，重新访问
//            //没抢到分布式锁，线程休眠，并进入递归重新调用本方法
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return  selectBySkuId(id);
//        }
//    }else if(skuInfoJson.equals("empty")){
//        return null;
//    }else{
//        pmsSkuInfo = JSON.parseObject(skuInfoJson, PmsSkuInfo.class);
//    }
//    jedis.close();
//    return pmsSkuInfo;
//}
@Override
public PmsSkuInfo selectBySkuId(Long id) {
    PmsSkuInfo pmsSkuInfo=null;
    Jedis jedis = redisUtil.getJedis();
    String skuKey= "sku:"+id+":info";
    String skuInfoJson = jedis.get(skuKey);
    if(skuInfoJson==null){
        //使用nx分布式锁，避免缓存击穿
        String skuLockKey="sku:"+id+":lock";
        String skuLockValue= UUID.randomUUID().toString();

        Lock lock = redissonClient.getLock("lock");// 声明锁
        lock.lock();//上锁
        //设置有效期
        jedis.expire(skuLockKey,60);
        if (lock!=null&&lock.equals("OK")){
            pmsSkuInfo = pmsSkuInfoMapper.selectByPrimaryKey(id);
            //防止缓存穿透，从DB中找不到数据也要缓存，但是缓存时间不要太长
            if (pmsSkuInfo!=null){
                //保存到redis
                String skuInfoJsonStr = JSON.toJSONString(pmsSkuInfo);
                //有效期随机，防止缓存雪崩
                Random random=new Random();
                int i = random.nextInt(10);
                jedis.setex(skuKey,i*60*1000,skuInfoJsonStr);

            }else{
                jedis.setex(skuKey,5*60*1000, "empty");
            }
            lock.unlock();// 解锁
            //删除分布式锁
            //解决思路是利用lua脚本在获得value后进行判断和删除
            String script ="if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            jedis.eval(script, Collections.singletonList(skuLockKey),Collections.singletonList(skuLockKey));
        }else {
            //如果分布式锁访问失败，线程休眠3秒，重新访问
            //没抢到分布式锁，线程休眠，并进入递归重新调用本方法
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return  selectBySkuId(id);
        }
    }else if(skuInfoJson.equals("empty")){
        return null;
    }else{
        pmsSkuInfo = JSON.parseObject(skuInfoJson, PmsSkuInfo.class);
    }
    jedis.close();

    return pmsSkuInfo;
}

}