package data.models;

public class CartItem {
    public final Product product;
    public final int count;
    public final int total;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
        total= product.price*count;
    }

    @Override
    public String toString() {
        return "Товар " + product.title +
                ", описание " + product.description +
                ", количество " + count +
                ", цена " + product.price + " стоимость " + total + "\n";
    }
}
