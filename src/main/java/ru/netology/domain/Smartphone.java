package ru.netology.domain;

public class Smartphone extends Product{
    private String maker;

    public Smartphone(int id, String name, int price, String maker) {
        super(id, name, price);
        this.maker = maker;
    }

    //Переопределенный метод по определению того подходит ли продукт поисковому запросу исходя из
// названия в дочернем классах. Он вызывает сначала родительский метод и только если родительский
// метод вернул false, тогда проводит доп.проверки (Book - по автору, Smartphone - по производителю).
    @Override
    public boolean matches(String search) {
        if (super.matches(search)) { // вызов метода matches в версии описанной в Product
            return true;
        }
        if (getMaker().matches(search)) { //если в родителе не нашлось, то идем проверять здесь по производителю
            return true;
        } else {
            return false;
        }
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }
}
