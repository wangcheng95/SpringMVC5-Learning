package com.waston.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//第一步：编写类型转换器
public class StringToDateConverter implements Converter<String, Date> {

    public Date convert(String s) {
        if(s == null)
            throw new RuntimeException("请您传入数据");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try{
            //将字符串转换日期
            return df.parse(s);
        }catch (Exception e){
            throw new RuntimeException("String2Date类型转换错误");
        }
    }
}
