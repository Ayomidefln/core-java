package Threads.Synchronization.Example1;

public class SynchronizedMethodE {
    int data;

    synchronized void getData(){
        System.out.println("Bot data: " + data);
    }

    synchronized void putData(int data){
        this.data = data;
        System.out.println("Put data: " + data);
    }
}


