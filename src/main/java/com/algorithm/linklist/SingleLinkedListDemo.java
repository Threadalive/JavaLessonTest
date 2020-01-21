package com.algorithm.linklist;

import java.util.Stack;

/**
 * @Description TODO
 * @Author zhenxing.dong
 * @Date 2020/1/4 16:05
 */
public class SingleLinkedListDemo {

    public static void main(String args[]) throws Exception {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode node1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode node2 = new HeroNode(2, "卢", "CS啊啊");
        HeroNode node3 = new HeroNode(3, "驱动器", "妻妾成群");
        HeroNode node4 = new HeroNode(4, "玩儿GV放弃", "充气式");


//        singleLinkedList.addNode(node1);
//        singleLinkedList.addNode(node3);
//        singleLinkedList.addNode(node2);

        singleLinkedList.addByOrder(node1);
        singleLinkedList.addByOrder(node3);
        singleLinkedList.addByOrder(node2);
        singleLinkedList.addByOrder(node4);

//        singleLinkedList.remove(node4);
//        reverseLinkList2(singleLinkedList.getHead());

        reversePrint(singleLinkedList.getHead());
//        singleLinkedList.list();

//        System.out.println("结点个数" + countNode(singleLinkedList.getHead()));
//
//        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 1));



    }

    /**
     * 利用栈逆序打印链表
     * @param head
     */
    public static void reversePrint(HeroNode head){
        if (head.next == null){
            System.out.println("空链表");
        }
        HeroNode cur = head.next;
        Stack<HeroNode> stack = new Stack<HeroNode>();
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 递归法反转链表,反转无表头链表
     *
     * @param head 原链表头
     * @return head
     */
    public static HeroNode reverseLinkList(HeroNode head) {
        if (head == null || head.next == null) {
            System.out.println("空列表");
            return head;
        }
        HeroNode temp = head.next;
        HeroNode newHead = reverseLinkList(head.next);
        temp.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 遍历法反转链表
     *
     * @param head 原链表头
     * @return
     */
    public static HeroNode reverseLinkList2(HeroNode head) {
        HeroNode pre = null;
        HeroNode next = null;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

        /**
         * 查找链表倒数第k个结点
         *
         * @param k    倒数第kge
         * @param head 头结点
         * @return 数第k个结点
         */
    public static HeroNode findLastIndexNode(HeroNode head, int k) throws Exception {

        if (head.next == null) {
            System.out.println("空列表");
            return null;
        }
        int size = countNode(head);
        if (k <= 0 || k > size) {
            throw new Exception("查询范围越界");
        }
        //第一个有效结点
        HeroNode cur = head.next;

        for (int i = 0; i < size - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 求有效结点个数
     *
     * @param head 头结点
     * @return 有效结点个数
     */
    public static int countNode(HeroNode head) {
        int count = 0;
        if (head.next == null) {
            return 0;
        }
        HeroNode cur = head.next;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }
}

/**
 * 管理Node
 */
class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    /**
     * 尾部添加结点
     *
     * @param heroNode
     */
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
     *
     * @param node 结点
     */
    public void addByOrder(HeroNode node) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            //已经在最后一个节点
            if (temp.next == null) {
                temp.next = node;
                break;
            } else if (temp.next.no > node.no) {
                node.next = temp.next;
                temp.next = node;
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("该node已存在");
        }
    }

    /**
     * 修改结点
     *
     * @param newNeroNode
     */
    public void update(HeroNode newNeroNode) {
        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                if (temp.no == newNeroNode.no) {
                    flag = true;
                    temp.name = newNeroNode.name;
                    temp.nickName = newNeroNode.nickName;
                    break;
                }
            }
            temp = temp.next;
        }
        if (!flag) {
            System.out.println("结点没有找到");
        }
    }


    /**
     * 删除一个节点
     */
    public void remove(HeroNode dHeroNode) {
        if (head.next == null) {
            System.out.println("空列表，无法删除");
            return;
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                System.out.println("无该结点");
                break;
            } else {
                if (temp.next.no == dHeroNode.no) {
                    temp.next = temp.next.next;
                    System.out.println("删除成功");
                    break;
                }
            }
            temp = temp.next;
        }
    }

    /**
     * 展示链表
     */
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

