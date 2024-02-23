package data.data_source.cart;

import data.models.Product;
import data.models.CartItem;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource {

    private ArrayList<CartItem> cart = new ArrayList<>();

    @Override
    public void addToCart(Product product, int count) {
            for (int i = 0; i < cart.size(); i++) {
                if (cart.get(i).product.equals(product)) {
                    int lastCount=cart.get(i).count;
                    cart.set(i, new CartItem(product, lastCount+count));
                    return;
                }
            }
        cart.add(new CartItem(product, count));
    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    @Override
    public void removeFromCart(int index) {
        cart.remove(index);
    }

    @Override
    public void clearCart() {
        cart.clear();
    }

    @Override
    public void changeCount(Product product, int count) {

    }
}
