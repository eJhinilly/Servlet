package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by localhost on 17-6-16.
 */

//购物车类
public class Cart {

    //购买商品的集合,value对应商品数量
    private HashMap<Items,Integer> goods ;

    //购物车的总金额
    private double totalprice;

    //构造方法
    public Cart(){

        //初始化属性
        goods = new HashMap<Items, Integer>();
        totalprice = 0.0;
    }

    public HashMap<Items, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Items, Integer> goods) {
        this.goods = goods;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    //添加商品进购物车的方法
    public boolean addGoodsInCart(Items item,int number){


        if(goods.containsKey(item))
        {
            goods.put(item, goods.get(item)+number);
        }
        else
        {
            goods.put(item, number);
        }

        calTotalPrice();//重新计算购物车总金额
        return true;
    }

    //删除商品的方法
    public boolean removeGoodsFromCart(Items item){
        goods.remove(item);
        calTotalPrice();
        return true;

    }

    //统计购物车的总金额
    public double calTotalPrice(){
        double sum = 0.0;
        Set<Items> keys = goods.keySet();//获得键的集合
        for (Items i:keys
             ) {
            sum += i.getPrice()*goods.get(i);
        }

//        Iterator<Items> it = keys.iterator();//获得迭代器对象
//        while (it.hasNext()){
//            Items i = it.next();
//            sum += i.getPrice();
//
//        }
        this.setTotalprice(sum);//设置总金额
        return this.getTotalprice();
    }

    public static void main(String[] args) {

        //先创建两个商品对象
        Items i1 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");
        Items i2 = new Items(2,"李宁运动鞋","广州",300,500,"002.jpg");

        //添加重复商品
        Items i3 = new Items(1,"沃特篮球鞋","温州",200,500,"001.jpg");

        Cart c = new Cart();
        c.addGoodsInCart(i1,1);
        c.addGoodsInCart(i2,2);
        c.addGoodsInCart(i3,3);

        //遍历购买商品的集合
        /**
         * hashmap 不能用迭代器遍历，所以用entrySet方法转换成Set类型
        **/
        Set<Map.Entry<Items,Integer>> items = c.getGoods().entrySet();
        for (Map.Entry<Items,Integer> obj:items
             ) {
            System.out.println(obj);
        }

        System.out.println("购物车总金额"+c.getTotalprice());
    }
}
