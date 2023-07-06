package entidades;

public class Persona {

    private String name;
    private int age;
    private char sex;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String name, int age, char sex, double peso, double altura) {
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.peso = peso;
        this.altura = altura;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
