package sun.jtutorial.core.xml.entity;

/**
 * Created by 148112 on 2015/6/5.
 */
public class Bar {
    private int id;
    private String title;
    private Zoo zoo;

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
