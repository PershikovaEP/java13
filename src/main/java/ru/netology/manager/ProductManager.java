package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }


    //добавляет Product в репозиторий
    public void add(Product product) {
        repo.save(product);
    }

    //получать все продукты
    public Product[] findAll() {
        return repo.findAll();
    }

    //осуществляет поиск по добавленным в репозиторий Product
//    Менеджер при переборе всех продуктов, хранящихся в репозитории, должен для каждого продукта вызывать
//    определённый в классе менеджера же метод matches, который проверяет, соответствует ли продукт поисковому
//    запросу.
    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты, изначаоотно нулевой
        for (Product product: repo.findAll()) {
            if (matches(product, text)) {
                // "добавляем в конец" массива result продукт product
                Product[] tmp = new Product[result.length + 1];//массив для хран-я найд.д-х длиной на 1 больше result
                tmp[tmp.length - 1] = product; //заполняем последнюю ячейку
                result = tmp; //заменяем
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    //При проверке на соответствие запросу товару мы проверяем вхождение запроса в текст названия товара.

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }


}
