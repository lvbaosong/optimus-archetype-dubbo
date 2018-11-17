package ${package}.domain.eo;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = -360211730780155756L;

    private String id;

    private String name;

    private Integer price;

    public Product() {}

    public Product(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}

