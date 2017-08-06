package hwa.seung.noh.suwonapp6th.adapterview;

/**
 * Created by fontjuna on 2017-08-07.
 */

public class People {
    private String name;
    private String phone;
    private int image;

    public People(String name, String phone, int image) {
        this.name = name;
        this.phone = phone;
        this.image = image;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", image=" + image +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
