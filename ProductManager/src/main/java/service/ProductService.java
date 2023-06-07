package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService<Product> {
    private List<Product> productList;

    public ProductService() {
        productList = new ArrayList<>();
        productList.add(new Product(1,"Máy tính bảng",11));
        productList.add(new Product(2,"Máy tính bàn",223));
        productList.add(new Product(3,"Máy tính laptop",33));
        productList.add(new Product(4,"Điện thoại cố định",44));
        productList.add(new Product(5,"Điện thoại di đông",555));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product_ = null;
        for(Product element : productList) {
            if (element.getId() == id) {
                product_ = element;
                break;
            }
        }
        return product_;
    }

    @Override
    public Product removeById(int id) {
        for (Product e: productList) {
            if (e.getId() == id) {
                productList.remove(e);
                break;
            }
        }
        return null;
    }
}
