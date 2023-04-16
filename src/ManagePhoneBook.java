import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagePhoneBook {
    static  PhoneBookManage phoneBookManage = new PhoneBookManage();

    public static void main(String[] args) throws IOException,ClassNotFoundException {
        String filePath = "ContactBook.txt";

        ArrayList<Contact> contacts = ReadFile.readFile(filePath);
        System.out.println(contacts);
        while (true){
            System.out.println(
                    "1:insert Phone \n"
                    +"2:display \n "
                   + "3:sort \n"
                    +"4:remove Phone \n"
                    +"5: update Phone \n "
                   + "6: search Phone \n"
                    +"0: exit \n"
            );
            String chon = new Scanner(System.in).nextLine();
            switch (chon){
                case  "1":
                    insertPhone();
                    break;
                case "2":
                    display();
                    break;
                case "3":
                    sort();
                    break;
                case "4":
                    remove();
                    break;
                case "5":
                    update();
                    break;
                case "6":
                    searchPhone();
                    break;
                case "0":
                    return;
            }
        }
    }
    public static void insertPhone() {
        System.out.println("Nhập tên liên lạc");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Nhập số điện thoại");
        String numberPhone = new Scanner(System.in).nextLine();
        System.out.println("Nhập typeID");
        String typeID = new Scanner(System.in).nextLine();
        System.out.println("nhập typeName");
        String nameType = new Scanner(System.in).nextLine();
        Type type = new Type(typeID, nameType);
        Contact contact = new Contact();
        contact.setName(name);
        contact.setPhoneNumber(numberPhone);

        phoneBookManage.insertPhone(contact);
    }
    public static void display() {
        System.out.println("Nhập 1 hiện 2 hiện theo type");
        String test = new Scanner(System.in).nextLine();
        switch (test) {
            case "1":
                phoneBookManage.display(null);
                break;
            case "2":
                System.out.println("Nhập ID");
                String id = new Scanner(System.in).nextLine();
                System.out.println("Nhập tên của type");
                String name = new Scanner(System.in).nextLine();
                Type type = new Type(id, name);
                phoneBookManage.display(type);
                break;
        }

    }
    public static void sort() {
        phoneBookManage.sort();
    }
    public static void remove() {
        System.out.println("Nhập tên Cần xóa");
        String name = new Scanner(System.in).nextLine();
        phoneBookManage.removePhone(name);
    }
    public static void update() {
        System.out.print("Nhập tên cần sửa");
        String name = new Scanner(System.in).nextLine();
        System.out.print("Nhập số điện thoại mới");
        String newPhone = new Scanner(System.in).nextLine();
        phoneBookManage.updatePhone(name, newPhone);
    }
    public static void searchPhone() {
        System.out.println("Nhập tên tên cần tìm");
        String name = new Scanner(System.in).nextLine();
        phoneBookManage.searchPhone(name);
    }
}
