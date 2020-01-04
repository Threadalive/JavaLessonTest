package com.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.StringWriter;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2019/11/20 14:17
 */
public class JavaJsonTest {
    public static void main(String args[]){
//        test2();

        String str = "Spring.pdf";
        String[] strings = str.split("\\.");
        System.out.println(strings[0]);
    }

    public static void test1(){
        JSONObject obj = new JSONObject();

        obj.put("name","foo");
        obj.put("num",new Integer(100));
        obj.put("balance",new Double(1000.21));
        obj.put("is_vip",new Boolean(true));

        StringWriter out = new StringWriter();
        obj.writeJSONString(out);
        String jsonText = out.toString();
        System.out.print(jsonText);
    }

    public static void test2(){
        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
        JSONArray jsonArray=(JSONArray) JSONArray.parse(s);

        System.out.println(jsonArray.get(1));
    }

    public static void test3(){
        String s = "\"name\":\"Bob\",\"occupation\": \"character\" ";

    }
}
