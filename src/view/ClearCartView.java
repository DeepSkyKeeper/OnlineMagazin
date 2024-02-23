package view;

import data.common.AppView;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class ClearCartView extends AppView {
    public ClearCartView(ShopService shopService) {
        super("Очистить корзину", new ArrayList<>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        if (!shopService.isCartEmpty()) {
            shopService.clearCart();
            System.out.println("Корзина очищена");
        } else System.out.println("Корзина пуста");

    }


}
