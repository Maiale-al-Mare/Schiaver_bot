import java.io.*;
import java.util.Map;

public class MapSerializer {

    public void writeMap(Map map1) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("map1.ser");
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
            oos.writeObject(map1);
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
            fis = new FileInputStream("map1.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map map2 = null;
        try {
            map2 = (Map) ois.readObject();
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

        System.out.println(map2);
        System.out.println("Serialized map1 in map1.ser");

        return map2;
    }
}
