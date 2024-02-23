package view;

import data.common.AppView;
import data.models.CartItem;
import data.models.Order;
import data.service.ShopService;

import java.util.ArrayList;

public class OrderView extends AppView {
    final ShopService shopService;
    public OrderView(ShopService shopService) {
        super("Просмотр заказа",new ArrayList<>());
        this.shopService = shopService;
    }


    @Override
    public void action() {
        System.out.println(shopService.getOrder());
    }
}
