import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class PhoneBookManage extends Phone implements IPhone {
    ArrayList<Contact> listContact;

    public PhoneBookManage() {
        this.listContact = new ArrayList<>();

    }

    public PhoneBookManage(ArrayList<Contact> contacts) {
        this.listContact = new ArrayList<>();
    }


    @Override
    public void searchPhone(String name) {
        boolean search = false;
        for (Contact ct : listContact) {
            if (ct.getName().equals(name)) {
                System.out.println("sdt" + name + ct.getPhoneNumber());
                search = true;
                break;
            }
        }
    }

    @Override
    public void sort() {
        Collections.sort(listContact, new Comparator<Contact>() {
            @Override
            public int compare(Contact a1, Contact a2) {
                return a1.getName().compareTo(a2.getName());
            }
        });

    }

    @Override
    public void display(Type type) {
        if (type == null) {
            System.out.println("hien thi tat ca");
            for (Contact ct : listContact) {
                if (ct.getType().equals(type)) {
                    System.out.println(ct);
                }
            }
        }

    }

    @Override
    public void insertPhone(Contact contact) {
        boolean insert = false;
        for (Contact ct : listContact) {
            if (ct.getType().equals(contact.getType())) {
                insert = true;
                break;
            }
        }
        if (insert) {
            for (Contact ct : listContact) {
                if (ct.getType().equals(contact.getType())) {
                    ct.setPhoneNumber(contact.getPhoneNumber());
                    break;
                }
            }
        } else {
            listContact.add(contact);
        }
        WriteFile.writeFile(listContact);
    }

    @Override
    public void removePhone(String name) {
        listContact.removeIf(contact -> contact.getName().equals(name));
        WriteFile.writeFile(listContact);

    }

    @Override
    public void updatePhone(String name, String newPhone) {
        for (Contact ct : listContact) {
            if (ct.getName().equals(name)) {
                ct.setPhoneNumber(newPhone);
                return;
            }
        }
        System.out.println(name + "khong co");
        WriteFile.writeFile(listContact);

    }
}
