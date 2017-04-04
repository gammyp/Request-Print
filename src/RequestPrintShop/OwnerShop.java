package RequestPrintShop;

public class OwnerShop extends Person {

    public OwnerShop(String name, String surname, String phone, String email) {
        super(name, surname, phone, email);
    }

    public OwnerShop(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "OwnerShop{" + "name=" + getName() + ", surname=" + getSurname() + ", phone=" + getPhone() + ", email=" + getEmail() + '}';
    }

}
