package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    Product[] products = new Product[0];

    //сохранять Products
    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1]; //массив на один больше длиной
        for (int i = 0; i < products.length; i++) { //пройдем по циклу
            tmp[i] = products[i]; //копируем
        }
        tmp[tmp.length - 1] = product; //заполняем последнюю ячейку
        products = tmp;
    }

    //получать Products
    public Product[] findAll() {
        return products;
    }

    //удалять по айди без исключений(то есть можно попросить удалить, если такого айди нет в массиве данных)
    public void removeById(int id) {
        Product[] tmp = new Product[length(id)];  //создали массив вычисленной длины
        int copyToIndex = 0; //переменная, сохраняющая место для копирования
        for (Product product : products) {  //пройдем по всему массиву
            if (product.getId() != id) {  //если id не совпадает, то копируем в эту ячейку, равную индексу, фильм
                tmp[copyToIndex] = product;
                copyToIndex++; //переставляем счетчик
            }
            products = tmp;
        }
    }

    // вычисляем длину массива для метода удаления по айди
    public int length(int id) {
        Product[] tmp = new Product[products.length];  //создали массив
        int length = 0; //счетчик- длина массива, изначально 0
        for (Product product : products) {  //пройдем по всему массиву
            if (product.getId() != id) {  //если id не совпадает, то
                length++; //переставляем счетчик
            }
        }
        return length;
    }

}
