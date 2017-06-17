package dao;

import entity.Items;
import util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by localhost on 17-6-10.
 */

//商品的业务逻辑类
public class ItemsDAO {

    //获得所有的商品信息
    public ArrayList<Items> getALLItems() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        //商品集合
        ArrayList<Items> list = new ArrayList<Items>();

        try {
            conn = DBHelper.getConnection();
            String sql = "select * from items;";//SQL语句
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                items.setCity(rs.getString("city"));
                items.setNumber(rs.getInt("number"));
                items.setPrice(rs.getInt("price"));
                items.setPicture(rs.getString("picture"));
                list.add(items);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            //释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    //根据商品编号获得商品资料
    public Items getItemsById(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DBHelper.getConnection();
            String sql = "select * from items where id=?;";//SQL语句
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Items items = new Items();
                items.setId(rs.getInt("id"));
                items.setName(rs.getString("name"));
                items.setCity(rs.getString("city"));
                items.setNumber(rs.getInt("number"));
                items.setPrice(rs.getInt("price"));
                items.setPicture(rs.getString("picture"));
                return items;
            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //释放数据集对象
            if (rs != null) {
                try {
                    rs.close();
                    rs = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            //释放语句对象
            if (stmt != null) {
                try {
                    stmt.close();
                    stmt = null;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取最近浏览的前五条商品信息
    public ArrayList<Items> getViewList(String list){
        System.out.println("list:"+list);
        ArrayList<Items> itemlist = new ArrayList<Items>();
        int iCount=5; //每次返回前五条记录
        if(list!=null&&list.length()>0)
        {
            String[] arr = list.split(",");
            //字符串数组arr保存访问记录id
            System.out.println("arr.length="+arr.length);
            //如果商品记录大于等于5条
            if(arr.length>=5)
            {
                for(int i=arr.length-1;i>=arr.length-iCount;i--)
                {
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            else
            {
                for(int i=arr.length-1;i>=0;i--)
                {
                    itemlist.add(getItemsById(Integer.parseInt(arr[i])));
                }
            }
            return itemlist;
        }
        else
        {
            return null;
        }
    }
}
