class Counter {
    private int num = 0;
    
    public synchronized void increase() {
        num++;
        System.out.println(Thread.currentThread().getName() + " - Number: " + num);
    }
    
    public synchronized void showNumbers(int base) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " shows: " + (base * i));
            if (i == 3) {
                try { wait(); } 
                catch (Exception e) {}
            }
        }
    }
    
    public synchronized void wakeThread() { notify(); }
}

class MyThread extends Thread {
    private Counter counter;
    
    public MyThread(Counter c, String name) {
        super(name);
        this.counter = c;
    }
    
    public void run() {
        System.out.println(getName() + " begins work");
        
        counter.increase();
        Thread.yield();
        
        synchronized(counter) {
            counter.showNumbers(2);
        }
        
        counter.wakeThread();
        System.out.println(getName() + " completes work");
    }
}

public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        
        MyThread t1 = new MyThread(c, "Thread-1");
        MyThread t2 = new MyThread(c, "Thread-2");
        MyThread t3 = new MyThread(c, "Thread-3");
        
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
        
        System.out.println("All threads finished!");
    }
}