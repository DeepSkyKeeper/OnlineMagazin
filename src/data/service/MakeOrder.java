package data.service;

import data.common.AppView;
import data.models.Order;
import data.models.Product;
import data.service.ShopService;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedMap;

public class MakeOrder extends AppView {
    final ShopService shopService;
    public MakeOrder (ShopService shopService) {
        super("Оформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }


    @Override
    public void action() {
        if (shopService.isCartEmpty()){
            System.out.println("Ошибка оформления заказа.Корзина пуста.Добавьте товары в корзину");
            return;
        }
        String [] types={"cash","credit card"};
        Scanner in = new Scanner(System.in);
        System.out.println("Введите свое имя");
        String name = in.nextLine();
        System.out.println("Введите свой телефон");
        String phone =in.nextLine();
        System.out.println("Введите свой адрес");
        String address=in.nextLine();
        System.out.println("Внимание! Открылось диалоговое окно...");
        Object paymentType= JOptionPane.showInputDialog(null,"Выберите тип оплаты","Оформление заказа",1,null,types,1);
        shopService.createOrder(name,phone,address,String.valueOf(paymentType),"утро 8-9 часов");
        System.out.println("Заказ успешно оформлен");;
    }
}
