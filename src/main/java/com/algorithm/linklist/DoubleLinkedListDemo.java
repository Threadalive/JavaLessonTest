package com.algorithm.linklist;

/**
 * @Description 双向链表
 * @Author zhenxing.dong
 * @Date 2020/1/21 15:05
 */
public class DoubleLinkedListDemo {
    public static void main(String args[]) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        HeroNode2 node1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 node2 = new HeroNode2(2, "卢", "CS啊啊");
        HeroNode2 node3 = new HeroNode2(3, "驱动器", "妻妾成群");
        HeroNode2 node4 = new HeroNode2(4, "玩儿GV放弃", "充气式");
        HeroNode2 node5 = new HeroNode2(3, "驱动器2", "asas");


        doubleLinkedList.addNode(node1);
        doubleLinkedList.addNode(node2);
        doubleLinkedList.addNode(node3);
        doubleLinkedList.addNode(node4);

        doubleLinkedList.remove(node4);
        doubleLinkedList.update(node5);
        doubleLinkedList.list();
    }
}

/**
 * 双向链表类
 */
class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    /**
     * 遍历双向链表
     */
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp.toString());
                temp = temp.next;
            }
        }
    }

    /**
     * 尾部添加结点
     *
     * @param heroNode
     */
    public void addNode(HeroNode2 heroNode) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else {
                temp = temp.next;
            }
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    /**
     * 修改结点
     *
     * @param newNeroNode
     */
    public void update(HeroNode2 newNeroNode) {

        boolean flag = false;
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
    public void remove(HeroNode2 dHeroNode) {
        if (head.next == null) {
            System.out.println("空列表，无法删除");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                System.out.println("无该结点");
                break;
            } else {
                if (temp.no == dHeroNode.no) {
                    temp.pre.next = temp.next;
                    if (temp.next != null) {
                        temp.next.pre = temp.pre;
                    }
                    System.out.println("删除成功");
                    break;
                }
            }
            temp = temp.next;
        }
    }

}

/**
 * Node2 双向链表结点
 */
class HeroNode2 {

    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;

    public HeroNode2(int no, String name, String nickName) {
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