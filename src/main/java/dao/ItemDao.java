package dao;

import entity.Item;

import java.util.List;

public interface ItemDao {
    public List<Item> findAll();
    public boolean insert(Item item);
    public boolean update(Item item);
}
