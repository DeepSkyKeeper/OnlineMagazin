package view;

import data.common.AppView;
import data.models.CartItem;
import data.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    final ShopService shopService;
    public CartView(ShopService shopService,ArrayList<AppView> children) {
        super("Корзина",children);
        this.shopService = shopService;
    }


    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        for (CartItem cartItem : cart) {
            System.out.println(cartItem.product.id + " " + cartItem.product.title + " " + cartItem.count);
        }
        System.out.println();
    }
}
