package com.rpcdemo.rpcimporter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @Description 客户端本地服务代理
 * @Author zhenxing.dong
 * @Date 2020/6/19 15:39
 */
public class RpcImporter<S> {
    public S importer(final Class<?> serviceClass, final InetSocketAddress address){
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(), new Class<?>[]{serviceClass.getInterfaces()[0]}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ObjectInputStream input = null;
                ObjectOutputStream output = null;
                Socket socket = null;

                try {
                    socket = new Socket();
                    socket.connect(address);

                    output = new ObjectOutputStream(socket.getOutputStream());

                    output.writeUTF(serviceClass.getName());
                    output.writeUTF(method.getName());
                    output.writeObject(method.getParameterTypes());
                    output.writeObject(args);

                    input = new ObjectInputStream(socket.getInputStream());
                    return input.readObject();
                }finally {
                    if (input != null){
                        try {
                            input.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (output != null){
                        try {
                            output.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (socket != null){
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
    }
}
