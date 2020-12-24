# 剑指 Offer 22. 链表中倒数第k个节点
---
### 题目描述

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
链表定义如下：

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */


---
### 题解思路
+ 简单的数据结构题
+ 遍历链表一遍统计链表的长度
+ 再次遍历当到倒数第k个节点时返回即可

---
### 代码

	class Solution {
    	public ListNode getKthFromEnd(ListNode head, int k) {
    	    ListNode p=head;
    	    int length=1;
    	    while(p.next!=null){
    	        length++;
    	        p=p.next;
    	    }
    	    p=head;
    	    int i=1;
    	    while(i<length-k+1){
    	        p=p.next;
    	        i++;
    	    }
    	    return p;
    	}
	}
