package data.data_source.cart;

import data.models.Product;
import data.models.CartItem;

import java.util.ArrayList;

public abstract class CartDataSource {

   public abstract void addToCart(Product product, int count);
   public abstract ArrayList<CartItem> getCart();

   public abstract void removeFromCart(int index);
   public  abstract void clearCart();
   public abstract void changeCount(Product product,int count);


 /*  Фичи:
           -просмотр каталога
      -добавление в корзину по id
         -сколько штук
      -просмотр корзины
      -оформить заказ
        -ввод данных
     */
}
