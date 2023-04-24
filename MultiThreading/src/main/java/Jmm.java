
class  BankAccounts implements  Runnable{
    private int balance=100;
    public int getBalance(){
        return this.balance;
    }

    @Override
    public  void run(){
         makeWithdrawl(75);
    }
    public synchronized void makeWithdrawl(int amnt){
        if(amnt<=this.balance){
            this.balance-=amnt;
            System.out.println("Mney withdawn by"+Thread.currentThread().getName());
        }else System.out.println("Not enough money");
    }
}


public class Jmm {
    public static void main(String[] args) {
        BankAccounts ba=new BankAccounts();
        Thread ram=new Thread(ba);
        Thread shyam =new Thread(ba);
        ram.start();shyam.start();
    }
}

/*Notes
suppose ram acquires the lock enters the make withdrawl updates the balance
at the same time if shyam tries to get the current balance,
he will get the old un updated value

we have to make sure shyam access the getbalance only after executes makewithdrawl
for shyam to see the latest balance
therrrrrrrre is a HAPPENS BEFORE relationship between two

to resolve this make getBalance also synchronized or make it volatile
so that any read operation will fetch latest value that is
done after  write operation

when jvm sees synchronized it understand ther need thread coodination
it introdce memory barriers
*/
