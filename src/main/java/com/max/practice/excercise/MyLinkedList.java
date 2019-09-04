package com.max.practice.excercise;

class MyLinkedList {
    private int size;
    private Node root;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        root = new Node(0);    
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (size < index || index < 0) return -1;   
        Node node = getNode(index);
        
        return node.val;
    }
    
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node head = root.prev;
        
        Node node = new Node(val);
        if (head == null) {
            root.next = node; 
            root.prev = node;
        } else {
            root.prev = node;
            node.next = head;
            head.prev = node;
        }
        size++;
        
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tail = root.next;
        
        Node node = new Node(val);
        if (tail == null) {
            root.next = node; 
            root.prev = node;
        } else {
            root.next = node;
            node.prev = tail;
            tail.next = tail;
        } 
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (size < index || index < 0) return;
        if (size - 1 == index) addAtTail(val);
        else if (0 == index) addAtHead(val);
        else {
            Node node = getNode(index);
            insertNode(node, val);
            size++;
        }
        
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (size < index || index < 0) return;
        
        Node node = getNode(index);
        
        if (node == root.prev) root.prev = node.next;
        if (node == root.next) root.next = node.prev;
        
        deleteNode(node);
        size--;    
    }
    private Node getNode(int index) {
        Node node = root.prev;
        while (index != 0) {
            node = node.next;
            index--;
        }    
        
        return node;
    }
    private void insertNode(Node node, int val) {
        Node prev = node.prev;
        
        Node newNode = new Node(val);
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = node;
        node.prev = newNode;
    }
    
    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private static class Node {
        Node prev;
        Node next;
        int val;
        
        Node(int val) {
            this.val = val;
        }
    }
}