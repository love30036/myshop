package view;

import entity.Item;
import impl.ItemDaoImpl;
import util.Tools;

import java.util.List;
import java.util.Scanner;

public class ItemPage {
    public  ItemDaoImpl itemDao;
    public  void mainPage() {
        itemDao = new ItemDaoImpl();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=======================");
            System.out.println("1.產品資訊");
            System.out.println("2.新增產品");
            System.out.println("3.購買產品");
            System.out.println("4.離開");
            System.out.println("請輸入選擇:");
            int choose = scanner.nextInt();
            if(choose==4 || choose == -1){
                break;
            }
            if(choose==1){
                select();
            }
            if(choose==2){
                insert();
            }
            Tools.pressAnyKey();
        }









//        Connection connection =DBUtil.getConnection();
//        System.out.println(connection);
//        try {
//            Statement statement = connection.createStatement();
//
//            String sqlstr = "update items set info='無備註' where info is null";
//
//            int result=statement.executeUpdate(sqlstr);
//
//            if(result>0){
//                System.out.println("新增成功！！");
//            }
//
//
//
//            ResultSet resultSet = statement.executeQuery("select * from items");
//
//            while (resultSet.next()){
//                int id  = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                float price = resultSet.getFloat("price");
//                int qty = resultSet.getInt("qty");
//                Date date = resultSet.getDate("create_date");
//                String info = resultSet.getString("info");
//
//                System.out.println(id +"\t"+ name +"\t"+ price +"\t"+ qty +"\t"+ date +"\t"+ info);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//
//
//        DBUtil.close(connection);
    }
    public  void select(){
        List<Item> items = itemDao.findAll();
        for(Item item:items){
            System.out.println(item);
        }
    }
    public  void insert(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("========================");
            System.out.println("商品名稱(-1:exit)");
            String name = scanner.nextLine();
            if(name.equals("-1")){
                break;
            }
            System.out.println("商品價格");
            double price = scanner.nextDouble();
            System.out.println("商品數量");
            int qty = scanner.nextInt();
            scanner.nextLine();
            System.out.println("請輸入日期(2020-01-01)");
            String data = scanner.nextLine();
            if(data.equals("")){
                data= Tools.getToday();
            }
            System.out.println("請輸入備註");
            String info = scanner.nextLine();

            itemDao.insert(new Item(name, price, qty, Tools.strToDate(data), info));
        }
    }
}
