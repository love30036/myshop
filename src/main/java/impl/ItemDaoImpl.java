package impl;

import dao.ItemDao;
import entity.Item;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        if(connection!=null) {
            try {

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from items");

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    float price = resultSet.getFloat("price");
                    int qty = resultSet.getInt("qty");
                    Date date = resultSet.getDate("create_date");
                    String info = resultSet.getString("info");

                    items.add(new Item(id, name, price, qty, date, info));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                    System.out.println("db close");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }


        return items;
    }
    public boolean insert(Item item){

        Connection connection = DBUtil.getConnection();
        if(connection!=null){
            String sqlStr = "insert into items (name,price,qty,create_date,info) values(?,?,?,?,?)";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlStr);
                preparedStatement.setString(1,item.getName());
                preparedStatement.setDouble(2,item.getPrice());
                preparedStatement.setInt(3,item.getQty());
                preparedStatement.setDate(4,item.getCreate_date());
                preparedStatement.setString(5,item.getInfo());

                preparedStatement.execute();

                System.out.println("資料新增成功");
                return true;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                DBUtil.close(connection);
                System.out.println("insert db close");
            }


        }

        return false;
    }

    @Override
    public boolean update(Item item) {
        Connection connection = DBUtil.getConnection();
        if(connection!=null){
            if(item.getQty()>0){

            }
        }
        return false;
    }
}
