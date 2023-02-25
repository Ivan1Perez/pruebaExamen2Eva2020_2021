package model;

import java.io.File;
import java.util.Comparator;
import java.util.List;

public interface MyStore<T>{

    void add(T e);

    T get(int index);

    T remove(int index);

    int size();

    void store(File f);

    void load(File f);

    String print();

    boolean contains(T e);

    List<T> sort();

    List<T> sort(Comparator<T> c);
}
