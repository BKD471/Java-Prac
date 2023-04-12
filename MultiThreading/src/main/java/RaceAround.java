
class BankAccount implements Runnable {
    private double balance;
    private double amount;

    BankAccount(double balance, double amount) {
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public void run() {
        withdrawCash(this.amount);
        if(this.balance<=0){
            System.out.println("Bhosdike account khali hay--->");
        }
    }

//    public  void  withdrawCash(double amount) {
//        System.out.println(String.format("%s is about to withdraw",Thread.currentThread().getName()));
//        if (amount <= this.balance) {
//            System.out.println(String.format("Current Balance is %s",this.balance));
//            this.balance -= amount;
//            System.out.println(String.format("Debited $%s from Laxmi Chit FUnd by %s",
//                    amount, Thread.currentThread().getName()));
//            System.out.println(String.format("Current Balance after withdrawl is %s",this.balance));
//        }else{
//            System.out.println(String.format("Sorry dont have enough balance %s",this.balance));
//        }
//    }

    public synchronized void  withdrawCash(double amount) {
        System.out.println(String.format("%s is about to withdraw",Thread.currentThread().getName()));
        if (amount <= this.balance) {
            System.out.println(String.format("Current Balance is %s",this.balance));
            this.balance -= amount;
            System.out.println(String.format("Debited $%s from Laxmi Chit FUnd by %s",
                    amount, Thread.currentThread().getName()));
            System.out.println(String.format("Current Balance after withdrawl is %s",this.balance));
        }else{
            System.out.println(String.format("Sorry dont have enough balance %s",this.balance));
        }
    }
}
public class RaceAround {
    public static void main(String[] args) {
        BankAccount task = new BankAccount(100,75);
        Thread a = new Thread(task);
        Thread b = new Thread(task);

        a.setName("Ram");
        b.setName("Shyam");

        a.start();
        b.start();
    }
}
