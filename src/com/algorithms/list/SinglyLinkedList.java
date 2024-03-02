package com.algorithms.list;

public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void printElements() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.print("null");

        System.out.println();
    }

    public int FindLength() {
        int count = 0;
        ListNode curNode = head;

        while (curNode != null) {
            count++;
            curNode = curNode.next;
        }
        return count;
    }

    public void InsertFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void InsertLast(int data) {
        ListNode newNode = new ListNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        ListNode curNode = head;
        while (curNode.next != null) {
            curNode = curNode.next;
        }

        curNode.next = newNode;
    }

    public void InsertPosition(int data, int position) {
        ListNode newNode = new ListNode(data);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            ListNode prevNode = head;
            int count = 1;

            while (count < position - 1) {
                prevNode = prevNode.next;
                count++;
            }

            ListNode curNode = prevNode.next;
            newNode.next = curNode;
            prevNode.next = newNode;
        }
    }

    public ListNode deleteFirst() {
        if (head == null) {
            return null;
        }
        ListNode tempNode = head;
        head = head.next;
        tempNode.next = null;
        return tempNode;
    }

    public ListNode deleteLast() {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode curNode = head;
        ListNode prevNode = null;

        while (curNode.next != null) {
            prevNode = curNode;
            curNode = curNode.next;
        }

        prevNode.next = null;
        return curNode;
    }

    public void deletePosition(int position) {
        if (position == 1) {
            head = head.next;
        }

        ListNode prevNode = head;
        int count = 1;

        while (count < position - 1) {
            prevNode = prevNode.next;
            count++;
        }

        ListNode curNode = prevNode.next;
        prevNode.next = curNode.next;

        curNode.next = null;
    }

    public boolean searchElement(int searchKey) {
        ListNode curNode = head;

        while (curNode != null) {
            if (curNode.data == searchKey) {
                return true;
            }

            curNode = curNode.next;
        }

        return false;
    }

    public ListNode reverseList() {
        ListNode curNode = head;
        ListNode prevNode = null;
        ListNode nextNode = null;

        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextNode;
        }

        return prevNode;
    }

    public ListNode findNthFromEnd(int n) {
        if (head == null) {
            return null;
        }

        if (n <= 0) {
            throw new IllegalStateException("Invalid input n: " + n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;

        while (count < n) {
            if (refPtr == null) {
                throw new IllegalArgumentException(n + " is greater than nodes length");
            }

            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null) {
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        return mainPtr;
    }

    public void removeDupeSorted() {
        ListNode curNode = head;

        while (curNode != null && curNode.next != null) {
            if (curNode.data == curNode.next.data) {
                curNode.next = curNode.next.next;
            }

            curNode = curNode.next;
        }
    }

    public void insertSorted(int data) {
        ListNode newNode = new ListNode(data);

        ListNode curNode = head;
        ListNode tempNode = null;

        while (curNode != null && curNode.data < newNode.data) {
            tempNode = curNode;
            curNode = curNode.next;
        }

        newNode.next = curNode;
        tempNode.next = newNode;
    }

    public void deleteByKey(int key) {
        ListNode curNode = head;
        ListNode tempNode = null;

        if (curNode != null && curNode.data == key) {
            head = curNode.next;
            return;
        }

        while (curNode != null && curNode.data != key) {
            tempNode = curNode;
            curNode = curNode.next;
        }

        if (curNode == null)
            return;

        tempNode.next = curNode.next;
    }

    public ListNode createLoopLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        return head;
    }

    public boolean detectLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                return true;
            }
        }

        return false;
    }

    public ListNode findLoopStart() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                return getStartingNode(slowPtr);
            }
        }

        return null;
    }

    public ListNode getStartingNode(ListNode slowPtr) {
        ListNode tempNode = head;

        while (slowPtr != tempNode) {
            tempNode = tempNode.next;
            slowPtr = slowPtr.next;
        }

        return tempNode;
    }

    public void removeTheLoop() {
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (slowPtr == fastPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    public void removeLoop(ListNode slowPtr) {
        ListNode tempNode = head;

        while (slowPtr.next != tempNode.next) {
            tempNode = tempNode.next;
            slowPtr = slowPtr.next;
        }

        slowPtr.next = null;
    }

    public ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if (a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }

        return dummy.next;
    }

    public ListNode addTwo(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (a != null || b != null) {
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;

            int sum = carry + x + y;

            carry = sum / 10;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            if (a != null) {
                a = a.next;
            }
            
            if (b != null) {
                b = b.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // sll.head = new ListNode(10);

        // ListNode second = new ListNode(1);
        // ListNode third = new ListNode(8);
        // ListNode fourth = new ListNode(11);

        // // Connect pointer
        // sll.head.next = second;
        // second.next = third;
        // third.next = fourth;

        // Find the Length
        // System.out.println(sll.FindLength());

        // sll.InsertFirst(15);
        // sll.InsertFirst(17);
        // sll.InsertFirst(2);
        // sll.InsertFirst(5);

        // sll.InsertLast(1);
        // sll.InsertLast(1);
        // sll.InsertLast(2);
        // sll.InsertLast(3);
        // sll.InsertLast(5);
        // sll.InsertLast(8);
        // sll.InsertLast(9);
        // sll.InsertLast(11);

        // sll.InsertPosition(5, 1);
        // sll.InsertPosition(4, 2);
        // sll.InsertPosition(8, 3);
        // sll.InsertPosition(3, 4);
        // sll.InsertPosition(9, 5);
        // sll.InsertPosition(7, 2);
        // sll.InsertPosition(7, 2);
        // sll.InsertPosition(7, 2);

        // sll.deleteFirst();

        // sll.deleteLast();

        // sll.deletePosition(2);

        // System.out.println(sll.searchElement(3));
        // System.out.println(sll.searchElement(2));

        // sll.printElements();

        // sll.head = sll.reverseList();

        // sll.removeDupeSorted();

        // sll.insertSorted(7);

        // // sll.printElements();

        // sll.deleteByKey(1);
        // sll.deleteByKey(7);

        // System.out.println(sll.detectLoop());

        // sll.head = sll.createLoopLinkedList();

        // System.out.println(sll.detectLoop());
        // sll.removeTheLoop();;
        // System.out.println(sll.detectLoop());

        // sll.printElements();

        // System.out.println(sll.findLoopStart());

        // Print Singly Linked List Elements

        // sll.printElements();

        // System.out.println(sll.findNthFromEnd(4).data);

        ListNode head1 = new ListNode(3);
        ListNode second1 = new ListNode(4);
        ListNode third1 = new ListNode(3);
        // ListNode fourth1 = new ListNode(4);

        head1.next = second1;
        second1.next = third1;
        // third1.next = fourth1;

        ListNode head2 = new ListNode(5);
        ListNode second2 = new ListNode(6);
        ListNode third2 = new ListNode(4);
        // ListNode fourth2 = new ListNode(5);

        head2.next = second2;
        second2.next = third2;
        // third2.next = fourth2;

        sll.head = head1;
        sll.printElements();

        sll.head = head2;
        sll.printElements();

        sll.head = sll.addTwo(head1, head2);

        sll.printElements();
    }
}
