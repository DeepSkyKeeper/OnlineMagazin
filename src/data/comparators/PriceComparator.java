package data.comparators;

import data.models.Product;

import java.util.Comparator;

public class PriceComparator implements Comparator<Product> {
    public boolean isAsk;//по возрастанию

    public PriceComparator(boolean isAsk) {
        this.isAsk = isAsk;
    }
    public PriceComparator() {
        this.isAsk = true;
    }
    @Override
    public int compare(Product p1, Product p2) {
        if (isAsk) {
            return p1.price - p2.price;
        } else
            return p2.price - p1.price;
    }
}
