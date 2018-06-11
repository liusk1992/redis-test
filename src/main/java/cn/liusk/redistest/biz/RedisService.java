/**
 * BEYONDSOFT.COM INC
 */
package cn.liusk.redistest.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liusk
 * @version $Id: RedisService.java, v 0.1 2018/6/7 14:06 liusk Exp $
 */
@Component
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name="stringRedisTemplate")
    private ValueOperations<String,String> valOpsStr;

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Resource(name = "redisTemplate")
    private ValueOperations<Object,Object> valOpsObj;

    /**
     * 根据指定key获取string
     * @param key
     * @return
     */
    public String getStr(String key){
        return valOpsStr.get(key);
    }

    /**
     * 设置string缓存
     * @param key
     * @param value
     */
    public void setStr(String key,String value){
        valOpsStr.set(key,value);
    }

    /**
     * 删除指定key
     * @param key
     */
    public void delKey(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 根据指定o获取Object
     * @param o
     * @return
     */
    public Object getObj(Object o){
        return valOpsObj.get(o);
    }

    /**
     * 设置obj缓存
     * @param o1
     * @param o2
     */
    public void setObj(Object o1, Object o2){
        valOpsObj.set(o1, o2);
    }

    /**
     * 删除Obj缓存
     * @param o
     */
    public void delObj(Object o){
        redisTemplate.delete(o);
    }
}
