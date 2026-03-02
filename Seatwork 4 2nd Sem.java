class Person {
    public String name;
    public int age;

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {

        Person p = new Person();

        p.name = "Maria";
        p.age = 18;

        p.display();
    }
}
