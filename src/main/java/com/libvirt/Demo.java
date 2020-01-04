package com.libvirt;

import org.libvirt.*;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2019/12/16 16:22
 */
public class Demo {
    public static void main(String args[]){
        Connect connect = null;
        try {
            connect = new Connect("qemu+ssh://root@192.168.157.134/system", false);
        } catch (LibvirtException e) {
            System.out.println("exception caught:" + e);
            System.out.println(e.getError());
        }

        try {
            NodeInfo nodeInfo = connect.nodeInfo();
            System.out.println("virNodeInfo.model:" + nodeInfo.model);
            System.out.println("virNodeInfo.memory:" + nodeInfo.memory);
            System.out.println("virNodeInfo.cpus:" + nodeInfo.cpus);
            // Exercise the information getter methods
            System.out.println("getHostName:" + connect.getHostName());
            System.out.println("getType:" + connect.getType());
            System.out.println("getURI:" + connect.getURI());

            // 获得inactive状态的虚拟机数量
            System.out.println("numOfDefinedDomains:" + connect.numOfDefinedDomains());
            // 获得inactive状态的虚拟机列表，返回值是String[],虚拟机名称的数组
            System.out.println("listDefinedDomains:" + connect.listDefinedDomains());

             for(int c:connect.listDomains()){
                 System.out.println("  ->"+c);
             }

            for (String c : connect.listStoragePools()) {
                StoragePool po = connect.storagePoolLookupByName(c);
                for(String v:po.listVolumes()) {
                    StorageVol vol = po.storageVolLookupByName(v);
                    System.out.println("‐‐‐‐> " + vol.getName());
                    System.out.println("‐‐‐‐‐‐‐> " + vol.getPath());
                }
            }
            connect.close();
        } catch (LibvirtException e) {
            System.out.println("exception caught:" + e);
            System.out.println(e.getError());
        }
        System.out.println("Fini!");
    }
}
