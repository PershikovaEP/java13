package ru.netology.domain;

public class Book extends Product{
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

//Переопределенный метод по определению того подходит ли продукт поисковому запросу исходя из
// названия в дочернем классах. Он вызывает сначала родительский метод и только если родительский
// метод вернул false, тогда проводит доп.проверки (Book - по автору, Smartphone - по производителю).
    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (getAuthor().matches(search)) { //если в родителе не нашлось, то идем проверять здесь по автору
            return true;
        } else {
            return false;
        }
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
