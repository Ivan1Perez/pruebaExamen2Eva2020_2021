package model;

import java.io.*;
import java.util.*;

public class MyList<T> implements MyStore<T>, Serializable{

    private int size;
    private Node<T> head;

    public MyList(){

    }

    @Override
    public void add(T info){
        Node<T> node = new Node<>(info);

        if(head==null){
            head = node;
        }else{
            node.setNext(head);
            head = node;
        }

        size++;
    }

    @Override
    public T get(int index){
        Node<T> node = head;
        T data = head.getInfo();

        if(index >= size || index < 0)
            return null;

        while(index > 0){
            data = node.getInfo();
            node = node.getNext();
            index--;
        }

        return data;
    }

    @Override
    public T remove(int index){
        MyList<T> aux = new MyList<>();
        Node<T> node = head;
        T data = head.getInfo();

        if(index >= size || index < 0)
            return null;

        for(int i = 0 ; i < size ; i++){
            if(i!=index){
                aux.add(node.getInfo());
            }
            data = node.getInfo();
            node = node.getNext();
        }

        head = aux.head;

        return data;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void store(File f){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))){
            oos.writeObject(this);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void load(File f){

        try(ObjectInputStream ios = new ObjectInputStream(new FileInputStream(f))){
            ios.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public String print(){
        Object[] o = new Object[size];
        Node<T> node = head;
        String text = "";

        for(Object ob : o){
            ob = node.getInfo();
            text += ob + "\n";
            node = node.getNext();
        }

        return text;
    }

    @Override
    public boolean contains(T info){
        Node<T> node = head;
        boolean found = false;

        while(node!=null){
            if(node.getInfo().equals(info))
                found = true;
            node = node.getNext();
        }

        return found;
    }

    @Override
    public List<T> sort(){
        List<T> list = new ArrayList<>();
        Node<T> node = head;

        while(node!=null){
            list.add(node.getInfo());
            node = node.getNext();
        }

        Collections.sort((List)list);

        return list;
    }

    @Override
    public List<T> sort(Comparator<T> c){
        List<T> list = new ArrayList<>();

        Node<T> node = head;

        while(node!=null){
            list.add(node.getInfo());
            node = node.getNext();
        }

        list.sort(c);

        return list;
    }

//    @Override
//    public boolean equals(Object obj){
//        if(obj instanceof MyList<?>){
//            MyList<T> lista = (MyList<T>) obj;
//            if(size!=lista.size)
//                return false;
//            else{
//                Node<T> aux1 = head;
//                Node<T> aux2 = lista.head;
//                boolean found = false;
//
//                while(aux1!=null && !found){
//                    if(aux1.getInfo().equals(aux2.getInfo()))
//                        found = true;
//                    aux1 = aux1.getNext();
//                    aux2 = aux2.getNext();
//                }
//
//                return found;
//            }
//
//        }
//
//        return false;
//    }

    @Override
    public String toString(){
        String output = "Total: " + size + "\n{";
        Node<T> node = head;

        while(node!=null){
            output += node.getInfo() + "\n";
            node = node.getNext();
        }

        return output + "}";
    }


    class Node<T> implements Serializable{

        private T info;
        private Node<T> next;

        public Node(T info){
            this.info = info;
        }

        public T getInfo(){
            return info;
        }

        public void setNext(Node<T> next){
            this.next = next;
        }

        public Node<T> getNext(){
            return next;
        }

        @Override
        public String toString(){
            return info.toString();
        }

    }

}
