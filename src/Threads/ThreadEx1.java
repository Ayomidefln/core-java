package Threads;

public class ThreadEx1 implements Runnable{
    public void run(){
        System.out.println("My Thread is in the running state");
        run2();
    }
    void run2(){
        System.out.println("Hey");
    }

    public static void main(String[] args) {
        ThreadEx1 obj = new ThreadEx1();
        Thread exe = new Thread(obj);
        exe.start();
    }
}
