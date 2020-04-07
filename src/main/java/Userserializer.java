import java.io.*;
import java.util.Map;

public class Userserializer {

    public void writeMap(Map map2) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("users.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.writeObject(map2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> readMap() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("users.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map map3 = null;
        try {
            map3 = (Map) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(map3);
        System.out.println("Serialized map1 in map1.ser");

        return map3;
    }
}
