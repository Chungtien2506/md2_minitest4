import java.io.Serializable;

public abstract class Phone  implements Serializable {
    public abstract void display(Type type);

    public abstract void insertPhone(Contact contact);

    public abstract void removePhone(String name);

    public abstract void updatePhone(String name, String newPhone);
}
