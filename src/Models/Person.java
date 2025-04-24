package Models;

public class Person {
    // atributos de la persona: nombre y edad   
    private int age;
    private String name;

    // constructor que recibe nombre y edad
    public Person (String name, int age){
    this.name=name;
    this.age=age;
    }

    //devuelve la edad
    public int getAge() {
        return age;
    }

    // actualiza la edad de la persona
    public void setAge(int age) {
        this.age = age;
    }
    // devuelve el nombre de la persona
    public String getName() {
        return name;
    }
    // actualiza el nombre de la persona
    public void setName(String name) {
        this.name = name;
    }
    // representa a la persona como texto
    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
    


    
}
