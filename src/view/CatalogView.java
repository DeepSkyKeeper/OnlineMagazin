package view;

import data.common.AppView;
import data.comparators.AppComparator;
import data.comparators.PriceComparator;
import data.models.Product;
import data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView {
    final ShopService shopService;
    public CatalogView(ShopService shopService, ArrayList<AppView> children, ArrayList<AppComparator<Product>>comparators) {
        super("Каталог", children);
        this.shopService = shopService;
        availableComparators.addAll(comparators);
        if(!availableComparators.isEmpty()){
            selectedComparator=availableComparators.get(0);
        }
    }


    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsk=false;
        ArrayList<Product> catalog = shopService.getCatalog(nowPage,pageLimit,selectedComparator.comparator);
        hasNextPage=catalog.size()==pageLimit;
        hasPreviousPage=nowPage>0;
        for (Product product : catalog) {
            System.out.println(product.id + " " + product.title + " " + product.price);
        }
        System.out.println();
    }
}
