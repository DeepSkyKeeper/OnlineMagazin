package data.common;

import data.comparators.AppComparator;
import data.models.Product;

import java.util.ArrayList;


public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public int nowPage = 0;
    public final int pageLimit = 5;
    public boolean hasNextPage = false;
    public boolean hasPreviousPage = false;

    public final ArrayList<AppComparator<Product>> availableComparators = new ArrayList<>();
    public AppComparator<Product> selectedComparator;

    public AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
        if (!availableComparators.isEmpty()) {
            selectedComparator = availableComparators.get(0);
        }
    }

    public void action() {
    }
}
