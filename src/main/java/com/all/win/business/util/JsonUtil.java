package com.all.win.business.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @Description: Json格式转换工具类
 * @Author: fakerCoder
 * @Date: 2018/7/6 14:23
 * @Version: 1.0.0
 */
public class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        //对象字段全部列入
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        //取消默认转换timestamp形式
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //忽略空bean转json的错误
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);

    }
}
