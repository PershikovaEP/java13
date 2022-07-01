package ru.netology.domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

public class ProductTest {

    @Test
    public void shouldReturnValueByNameSmartphone() {
        Product product = new Smartphone( 2, "Samsung2", 15_000, "Korea" );

        Boolean expected = true;
        Boolean actual = product.matches("Samsung2");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueByMakerSmartphone() {
        Product product = new Smartphone(2, "Samsung2", 15_000, "Korea");

        Boolean expected = true;
        Boolean actual = product.matches("Korea");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueByNameBook() {
        Product product = new Book( 1, "Первая книга", 500, "Иванов Иван" );

        Boolean expected = true;
        Boolean actual = product.matches("Первая книга");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueByAuthorBook() {
        Product product = new Book( 1, "Первая книга", 500, "Иванов Иван" );

        Boolean expected = true;
        Boolean actual = product.matches("Иванов Иван");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueByNameBookWhenPartName() {
        Product product = new Book( 1, "Первая книга", 500, "Иванов Иван" );

        Boolean expected = true;
        Boolean actual = product.matches("Первая");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueWhenNotNameProduct() {
        Product product = new Book( 1, "Первая книга", 500, "Иванов Иван" );

        Boolean expected = false;
        Boolean actual = product.matches("Первый");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueWhenNotAuthorBook() {
        Product product = new Book( 1, "Первая книга", 500, "Иванов Иван" );

        Boolean expected = false;
        Boolean actual = product.matches("Петров");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnValueWhenNotMakerSmartphone() {
        Product product = new Smartphone( 2, "Samsung2", 15_000, "Korea" );

        Boolean expected = false;
        Boolean actual = product.matches("Chine");

        assertEquals(expected, actual);
    }

}
