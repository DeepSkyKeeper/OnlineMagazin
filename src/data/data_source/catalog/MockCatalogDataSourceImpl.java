package data.data_source.catalog;

import data.models.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MockCatalogDataSourceImpl extends CatalogDataSource {
    @Override
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator) {
        ArrayList<Product> products = generateProducts();
        Stream<Product> productStream=products.stream().filter(p->p.available)
                .sorted(comparator).skip((long)page * limit).limit(limit);
        return new ArrayList<>(productStream.collect(Collectors.toList()));
    }

    @Override
    public ArrayList<Product> getCatalog(int page, int limit) {
        //добавление
        ArrayList<Product> products = generateProducts();
        //пагинация
        Stream<Product> productStream=products.stream().filter(p->p.available)
                .skip((long)page * limit).limit(limit);
        return new ArrayList<>(productStream.collect(Collectors.toList()));
    }

    @Override
    public Product productById(String id) {
        ArrayList<Product> products = getCatalog(0, 9999999);
        for (Product p : products
        ) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        return null;

    }

    ArrayList<Product> generateProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("id1", "SmartPhone", "Best phone", 1000, true));
        products.add(new Product("id2", "Laptop", "Best laptop", 2000, true));
        products.add(new Product("id3", "Watch", "Best watch", 500, true));
        products.add(new Product("id4", "Phone", "Simple Phone", 100, true));
        for (int i = 0; i < 20; i++) {
            products.add(new Product("id" + (i + 5), "IPhone-" + i, "Simple Phone", 100 + i * 100, i % 4 != 0));
        }
        return products;
    }

}
    /*
    dataSource
    ------
    services (проверки, обработка нескольких datasources)
    controllers (обработка введенных данных)
    views (то что показывается пользователю)

    0..30
    page 0 limit 10: 0..9
    page 1 limit 10: 10..19
    page 1 limit 7: 7..13

     */



