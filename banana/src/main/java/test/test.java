package test;


import sun.rmi.runtime.NewThreadAction;

class Phone{
        public synchronized void sendMS() throws Exception{
            System.out.println(Thread.currentThread().getId() +"\t invoked sendMS()");
            sendEmail();
        }

    public synchronized void sendEmail() throws Exception{
            sendMS();
        System.out.println(Thread.currentThread().getId() +"\t invoked sendEmail()");
    }

}
public class test {
    volatile int n = 0;
    public void add(){
        n++;
    }

    public static void main(String[] args) {
        Phone phone = new Phone();

        new Thread(()->{
            try {
                phone.sendMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();


        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
        }
}
