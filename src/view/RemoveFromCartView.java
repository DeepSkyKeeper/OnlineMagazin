package view;

import data.common.AppView;
import data.models.CartItem;
import data.models.Product;
import data.service.InputData;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveFromCartView extends AppView {
    public RemoveFromCartView(ShopService shopService) {
        super("Удалить товар", new ArrayList<>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {

        System.out.println("Удаление товара:");
        System.out.println("Введите id удаляемого товара");
        InputData inputData = new InputData();
        String productId = inputData.in.nextLine();
        if (productId == null) return;
        if (checkCartId(productId)) {
            if (shopService.removeFromCart(productId));
            System.out.println("Товар удален");
        } else {
            System.out.println("Не удалось удалить товар");
        }
    }
    boolean checkCartId(String productId) {
        ArrayList<CartItem> items = shopService.getCart();
        for (CartItem ci : items
        ) {
            if (ci.product.id.equals(productId)) return true;
        }
        return false;
    }
}
