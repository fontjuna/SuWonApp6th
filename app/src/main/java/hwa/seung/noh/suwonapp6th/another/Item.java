package hwa.seung.noh.suwonapp6th.another;

/**
 * Created by fontjuna on 2017-08-08.
 */

public class Item {
    private int image;
    private String name;
    private String phone;

    public Item(int image, String name, String phone) {
        this.image = image;
        this.name = name;
        this.phone = phone;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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
}
