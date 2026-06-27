package section7_synchronized;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankMain {
    public static void main(String[] args) throws InterruptedException {
        BankAccount bankAccount = new BankAccountV3(1000);

        Thread t1 = new Thread(new WithdrawTask(bankAccount, 800), "t1");
        t1.start();

        Thread t2 = new Thread(new WithdrawTask(bankAccount, 800), "t2");
        t2.start();

        sleep(500);
        log("t1.getState = " + t1.getState() + ", t2.getState = " + t2.getState());

        t1.join();

        log("##### 최종잔액 : %d #####".formatted(bankAccount.getBalance()));
    }
}
