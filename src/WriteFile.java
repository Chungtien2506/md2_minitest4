import java.io.*;
import java.util.ArrayList;

public class WriteFile <E>{
    public  static  void writeFile(ArrayList<Contact> listContact){
        File file =  new File("ContactBook.txt");
        try {
            FileOutputStream fop = new FileOutputStream(file);
           ObjectOutputStream oop = new ObjectOutputStream(fop);
           oop.writeObject(listContact);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
