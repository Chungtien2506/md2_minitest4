import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadFile <E>{
    public  static <E> ArrayList<E> readFile  (String filePath) {
        ArrayList<E> data = new ArrayList<>();
        try {
            FileInputStream fip = new FileInputStream(filePath);
            ObjectInputStream oip = new ObjectInputStream(fip);
            data = (ArrayList<E>)  oip.readObject();
            } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    }

