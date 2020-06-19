package com.rpcdemo.test;

import com.rpcdemo.rpcexport.RpcExporter;
import com.rpcdemo.rpcimporter.RpcImporter;
import com.rpcdemo.service.EchoService;
import com.rpcdemo.service.EchoServiceImpl;

import java.net.InetSocketAddress;

/**
 * @Description rpc测试
 * @Author zhenxing.dong
 * @Date 2020/6/19 15:53
 */
public class RpcTest {
    public static void main(String args[]){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8080);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();
        EchoService echo = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8080));
        System.out.println(echo.echo("Are you ok?"));
    }
}
