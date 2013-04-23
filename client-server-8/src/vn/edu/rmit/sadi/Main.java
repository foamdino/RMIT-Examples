package vn.edu.rmit.sadi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {

            List<Person> people = new ArrayList<Person>();
            Person john = new Person("John", "john1234", 25);
            Person jane = new Person("Jane", "jane1234", 27);

            john.setFriend(jane);
            jane.setFriend(john);

            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(
                        new FileOutputStream("people.dat"));
                oos.writeObject(john);
            } finally {
                if (oos != null) oos.close();
            }

            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(
                        new FileInputStream("people.dat"));
                Person savedJohn = (Person)ois.readObject();
//                for (Person p : savedPeople) {
//                    System.out.println(p);
//                }
                System.out.println(savedJohn);
                System.out.println(savedJohn.getFriend());
                System.out.println(savedJohn.getFriend().getFriend());
            } finally {
                if (ois != null) {
                    ois.close();
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
