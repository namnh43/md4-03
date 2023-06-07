package service;

import java.util.List;

public interface IProductService<T> {
    List<T> findAll();
    T findById(int id);
    T removeById(int id);
}
