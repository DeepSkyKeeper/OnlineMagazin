package data.models;

import java.util.ArrayList;

public class Order {
    public final String name;
    public final String phone;
    public final String address;
    public final String paymentType;
    public final String deliveryTime;
    public final ArrayList cartItem;
    public static int totalCost;

    public Order(String name, String phone, String address, String paymentType, String deliveryTime, ArrayList cartItem) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.cartItem = cartItem;
        calcTotal();
    }

    @Override
    public String toString() {
        return "Заказ {" +
                "Имя: '" + name + '\'' +
                ", телефон: '" + phone + '\'' +
                ", адрес: '" + address + '\'' +
                ", тип оплаты: '" + paymentType + '\'' +
                ", время доставки: '" + deliveryTime + '\'' + "\n" +
                ", Товары: " + "\n" + cartItem +
                '}'+"\n"+
                "Общая сумма заказа :"+totalCost;
    }
public void calcTotal(){
        for(int i=0;i<cartItem.size();i++) {
            totalCost+=((CartItem) cartItem.get(i)).total;
        }
}
}
