package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Первая книга", 500, "Иванов Иван" );
    Product product2 = new Smartphone(2, "Samsung2", 15_000, "Korea");
    Product product3 = new Book(3, "Вторая книга", 1_000, "Петров Петр");

    @Test
    public void shouldAddOtherProducts() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = { product1, product2, product3 };
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd1ProductsBook() {
        manager.add(product1);

        Product[] expected = { product1 };
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd1ProductsSmartphone() {
        manager.add(product2);

        Product[] expected = { product2 };
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAdd0Products() {

        Product[] expected = { };
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = { product2 };
        Product[] actual = manager.searchBy("Samsung2");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameBookWhenPartName() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = { product1 };
        Product[] actual = manager.searchBy("Первая");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameWhenNotName() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] expected = { };
        Product[] actual = manager.searchBy("Привет");

        assertArrayEquals(expected, actual);
    }


}
