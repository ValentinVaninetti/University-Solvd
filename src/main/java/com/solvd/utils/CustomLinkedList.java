package com.solvd.utils;


import com.solvd.entities.university.Department;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLinkedList<E> {
    private static final Logger LOGGER = LogManager.getLogger(CustomLinkedList.class);
    private Node<E> first;
    private Node<E> last;
    private int lenght = 0;

    public CustomLinkedList() {

    }

    public CustomLinkedList(Node<E> head, Node<E> last) {
        this.first = head;
        this.last = last;
    }

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }

    public Node<E> getLast() {
        return last;
    }

    public void setLast(Node<E> last) {
        this.last = last;
    }

    public int getLenght() {
        return lenght;
    }

    public void insertAtEnd(E data) {
        Node<E> node = new Node<>(data);
        if (this.isEmpty()) {
            insertIfEmpty(node);
        } else {
            this.getLast().setNext(node);
            node.setPrev(this.getLast());
            node.setNext(null);
            this.setLast(node);
            lenght++;
        }

    }

    public void addElementAt(E data, int index) {
        Node<E> node = new Node<>(data);
        Node<E> tempNode = this.first;
        int i = 0;

        if (index <= lenght) {
            while (positionNotFound(index, i)) {
                tempNode = tempNode.getNext();
                i++;
            }
            if (itShouldBeLast(i)) {
                this.insertAtEnd(data);
            } else if (i == 0) {
                insertAtFirst(data);
            } else {
                insertNode(node, tempNode);
            }
        } else {
            LOGGER.info("Index is out of bounds for this value: " + index);
            throw new IndexOutOfBoundsException();
        }
    }

    private void insertNode(Node<E> node, Node<E> tempNode) {
        node.setPrev(tempNode.getPrev());
        node.setNext(tempNode);
        tempNode.getPrev().setNext(node);
        tempNode.setPrev(node);
        tempNode.setNext(tempNode.getNext().getNext());
        this.lenght++;
    }

    private boolean itShouldBeLast(int i) {
        return i == lenght && i != 0;
    }

    private boolean positionNotFound(int index, int i) {
        return i < lenght && i != index;
    }

    public void insertAtFirst(E data) {
        Node<E> node = new Node<>(data);
        if (isEmpty()) {
            insertIfEmpty(node);
        } else {
            node.setPrev(null);
            node.setNext(this.getFirst());
            this.getFirst().setPrev(node);
            if (this.getFirst().getNext() == null) {
                this.getFirst().setNext(null);
                this.setLast(this.getFirst());
            }
            this.setFirst(node);
            this.lenght++;
        }
    }

    private void insertIfEmpty(Node<E> node) {
        this.first = node;
        this.last = node;
        node.setPrev(null);
        node.setNext(null);
        this.lenght++;
    }

    public boolean isEmpty() {
        return this.lenght == 0;
    }

    @Override
    public String toString() {
        return "CustomLinkedList{" +
                "first=" + first +
                ", last=" + last +
                ", lenght=" + lenght +
                '}';
    }
}
