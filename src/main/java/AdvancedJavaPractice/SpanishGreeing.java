package AdvancedJavaPractice;

public class SpanishGreeing implements Greeting{
    @Override
    public String greeting(String name) {
        return "Hola "+ name +"!";
    }
}
