package com.rpcdemo.rpcexport;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @Description 服务发布者
 * @Author zhenxing.dong
 * @Date 2020/6/19 14:58
 */
public class RpcExporter  {
    //根据处理器个数创建线程池
    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * 监听端口，发布任务
     * @param hostName
     * @param port
     * @throws Exception
     */
    public static void exporter(String hostName, int port)throws Exception{
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName,port));

        try {
            while (true){
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            serverSocket.close();
        }
    }


    private static class ExporterTask implements Runnable{

        Socket clientSocket = null;

        public ExporterTask(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            ObjectInputStream input = null;
            ObjectOutputStream output = null;

            try {
                input = new ObjectInputStream(clientSocket.getInputStream());
                String interfacename = input.readUTF();
                Class<?> service = Class.forName(interfacename);

                String mothedName = input.readUTF();

                Class<?>[] parametersType = (Class<?>[])input.readObject();

                Object[] parameters = (Object[]) input.readObject();

                Method method = service.getMethod(mothedName,parametersType);

                //反射执行方法
                Object result = method.invoke(service.newInstance(),parameters);

                output = new ObjectOutputStream(clientSocket.getOutputStream());

                //将本地执行结果序列化返回
                output.writeObject(result);

            } catch (Exception e) {
                e.printStackTrace();
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

                    if (clientSocket != null){
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                }
            }
        }
    }
}

