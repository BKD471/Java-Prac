import java.util.concurrent.atomic.AtomicLong;

class IdGenerator{

    private AtomicLong id=new AtomicLong();

    public Long getId(){
        return id.getAndIncrement();
    }
}

public class AtomicVars {
    public static void main(String[] args) {
        IdGenerator idg=new IdGenerator();

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(idg.getId());
            }
        });

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(idg.getId());
            }
        });

        Thread t4=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(idg.getId());
            }
        });
        t1.start();t2.start();t4.start();
    }
}
/*

* tomic vars always givenew vals
*
* */