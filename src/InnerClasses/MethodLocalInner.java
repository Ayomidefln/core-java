package InnerClasses;

public class MethodLocalInner {
    private String x = "my outerclass";

    void display(){
        final String z = "Local Variable";
        System.out.println("x: " + x);

        class Inner{
            public void print(){
                System.out.println("Will it print x?" + x);
                System.out.println("Will it print z?" + z);
            }
        }

        Inner run = new Inner();
        run.print();
    }

    public static void main(String[] args) {
        MethodLocalInner inner = new MethodLocalInner();
        inner.display();
    }
}
