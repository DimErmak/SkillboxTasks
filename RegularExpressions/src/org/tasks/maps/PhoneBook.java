package org.tasks.maps;

public class PhoneBook {
    private String phone;
    private String name;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PhoneBook(int id, String phone, String name) {
        this.phone = phone;
        this.name = name;
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
