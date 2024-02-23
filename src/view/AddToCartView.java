package view;

import data.common.AppView;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class AddToCartView extends AppView {
    public AddToCartView(ShopService shopService) {
        super("Добавить товар", new ArrayList<>());
        this.shopService = shopService;
    }

    final ShopService shopService;

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id продукта");
        String productId = in.nextLine();
        if (productId == null) return;
        if (checkId(productId)) {
            System.out.println("Введите количество");
            int count = in.nextInt();
            shopService.addToCart(productId, count);
            System.out.println("Товар добавлен");
        } else {
            System.out.println("Не удалось добавить товар");
        }
    }

    boolean checkId(String productId) {
        ArrayList<Product> products = shopService.getCatalog(0,99999);
        for (Product p : products
        ) {
            if (p.id.equals(productId)) return true;
        }
        return false;
    }
}
