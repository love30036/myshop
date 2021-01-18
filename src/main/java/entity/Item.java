package entity;

import java.sql.Date;
//import java.util.Date;
public class Item {
    private int id;
    private String name;
    private double price;
    private int qty;
    private Date create_date;
    private String info;

    public Item(int id, String name, double price, int qty, Date create_date, String info) {
        this(name,price,qty,create_date,info);
        this.id = id;

    }
    public Item(String name, double price, int qty, Date create_date, String info) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.create_date = create_date;
        this.info = info;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name +
                ", price=" + price +
                ", qty=" + qty +
                ", create_date=" + create_date +
                ", info='" + info ;

    }
}
