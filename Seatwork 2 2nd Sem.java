class Person {
    private String name;
    private int age;

    public void setData(String n, int a) {
        name = n;
        age = a;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {

        Person p = new Person();

        p.setData("John", 20);

        p.display();
    }
}
