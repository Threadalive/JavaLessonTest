package com.rpcdemo.service;

/**
 * @Description 远程服务具体实现
 * @Author zhenxing.dong
 * @Date 2020/6/19 14:55
 */
public class EchoServiceImpl implements EchoService{
    @Override
    public String echo(String ping) {
        return ping != null ? ping+"——>I am ok!":"I am ok!";
    }
}
