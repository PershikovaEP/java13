package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product product1 = new Book(1, "Первая книга", 500, "Иванов Иван" );
    Product product2 = new Smartphone(2, "Samsung2", 15_000, "Korea");
    Product product3 = new Book(3, "Вторая книга", 1_000, "Петров Петр");

    @Test
    public void shouldSaveOtherProducts() {

        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        Product[] expected = { product1, product2, product3};
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave1ProductBook() {

        repo.save(product1);

        Product[] expected = { product1 };
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave1ProductSmartphone() {

        repo.save(product1);

        Product[] expected = { product1 };
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSave0Product() {

        Product[] expected = { };
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        repo.removeById(2);

        Product[] expected = { product1, product3 };
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByIdWhenNotId() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);

        repo.removeById(8);

        Product[] expected = { product1, product2, product3 };
        Product[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }
}
