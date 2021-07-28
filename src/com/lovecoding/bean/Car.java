package com.lovecoding.bean;

public class Car {

    private String name;
    private String color;
    private Double price;

    public Car() {
    }

    public Car(String name , Double price){
        System.out.println("Car(String name , Double price)");
        this.name = name;
        this.price = price;
    }

    public Car(int name , Double price){
        System.out.println("Car(int name , Double price)");
        this.name = name + "";
        this.price = price;
    }
    public Car(Double price , String name){
        System.out.println(" Car(Double price , String name)");
        this.name = name;
        this.price = price;
    }

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
