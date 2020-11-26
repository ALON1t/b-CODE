package com.Demo;

class Shape {
    public void draw() {

    }
}

class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("⭕");
    }
}

class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("♦");
    }

}
class Money {
    public double money;
}
class  Person implements Cloneable{//Cloneable,空接口，标记接口，标记当前接口是可以克隆的
    public String name;
    public Money m;
    public Person(String name) {
        this.name = name;
        this.m = new Money();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override//重写克隆方法，是Object的方法
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Demo1 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("hhh");
        Person person1 = (Person) person.clone();//clone的类型是Object，这里是person类型，
                                                 // 所以需要强转为Person类型
        System.out.println(person1);
    }

    public static void drawMap(Shape shape) {
        shape.draw();//传的是Shape的子类——》多态
    }

    public static void main1(String[] args) {
        /*Shape shape = new Cycle();//向上转型
        Shape shape1 = new Rect();//
        drawMap(shape);
        drawMap(shape1);*/

        Shape[] shapes = {new Cycle(),new Rect()};
        for (Shape shape : shapes) {
            shape.draw();
        }
       /* Shape shape = new Cycle();
        Shape shape1 = new Rect();*/
        /*drawMap(shape);
        drawMap(shape1);*/
    }
}
