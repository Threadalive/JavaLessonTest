package com.algorithm.linklist;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/1/4 16:05
 */
public class SingleLinkedListDemo {

    public static void main(String args[]) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢", "CS啊啊");
        HeroNode node3 = new HeroNode(3, "驱动器", "妻妾成群");

//        singleLinkedList.addNode(node1);
//        singleLinkedList.addNode(node3);
//        singleLinkedList.addNode(node2);

        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node2);

        singleLinkedList.list();
    }
}

/**
 * 管理Node
 */
class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public void addNode(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        temp.next = heroNode;
    }

    /**
     * 按序添加
     * @param node 结点
     */
    public void addByOrder(HeroNode node){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            //已经在最后一个节点
            if (temp.next == null){
                temp.next = node;
                break;
            }else if (temp.next.no > node.no){
                node.next = temp.next;
                temp.next = node;
                break;
            }else if (temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag){
            System.out.println("该node已存在");
        }
    }


    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }

    }
}

/**
 * Node
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

