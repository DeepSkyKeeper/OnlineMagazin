import data.common.*;
import data.comparators.AppComparator;
import data.comparators.PriceComparator;
import data.data_source.cart.CartDataSource;
import data.data_source.cart.MockCartDataSourceImpl;
import data.data_source.catalog.CatalogDataSource;
import data.data_source.catalog.MockCatalogDataSourceImpl;
import data.data_source.order.MockOrderDataSourceImpl;
import data.data_source.order.OrderDataSource;
import data.models.Product;
import data.service.MakeOrder;
import data.service.ShopService;
import view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        ArrayList<AppView> cartChildren = new ArrayList<>();
        AppView removeFromCartView=new RemoveFromCartView(shopService);
        AppView clearCartView=new ClearCartView(shopService);
        cartChildren.add(removeFromCartView);
        cartChildren.add(clearCartView);
        AppView addToCartView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);
        ArrayList<AppComparator<Product>> catalogComparators=new ArrayList<>();
        catalogComparators.add(new AppComparator<>(new PriceComparator(true),"по возрастанию цены"));
        catalogComparators.add(new AppComparator<>(new PriceComparator(false),"по убыванию цены"));
        AppView catalogView = new CatalogView(shopService, catalogChildren,catalogComparators);

        AppView cartView = new CartView(shopService,cartChildren);
        AppView makeOrder = new MakeOrder(shopService);
        AppView orderView = new OrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(makeOrder);
        mainChildren.add(orderView);

        AppView mainView = new MainView(mainChildren);


        new PageLoop(mainView).run();

    }

    /*
    models:
    Product-id,title,description,price,available
    Order -name,phone,address,paymentType,deliveryTime,List<CartItem> cart
    Фичи:
    -просмотр каталога
      -добавление в корзину по id
         -сколько штук
      -просмотр корзины
      -оформить заказ
        -ввод данных
     */
}