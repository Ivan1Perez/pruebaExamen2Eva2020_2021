package model;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        MyList<Restaurant> m1 = new MyList<>();
        File file = new File("myFile");

        Restaurant p1 = new Restaurant("Casa Pepe", 83.12, 55.01, 4);
        Restaurant p2 = new Restaurant("Il forno di pietra", 95.15, 50.41, 3);
        Restaurant p3 = new Restaurant("La cuina", 21.21, 190.03, 3);

        m1.add(p1);
        m1.add(p2);
        m1.add(p3);

        m1.store(file);

//        m1.remove(1);
//        System.out.println(m1.sort());

        System.out.println(m1.sort((o1, o2) -> o2.getStars() - o1.getStars()));

        m1 = new MyList<Restaurant>();

        m1.load(file);

        System.out.println(m1.print());

    }
}