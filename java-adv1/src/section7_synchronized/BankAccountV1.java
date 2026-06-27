package section7_synchronized;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {

    private int balance;

    /**
     * 생성자
     * @param balance
     */
    public BankAccountV1(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("##### 거래시작 #####");
        log("##### 출금액 : %d, 잔액 : %d #####".formatted(amount, this.balance));

        if (this.balance < amount) {
            // 잔고 < 출금액
            log("##### [출금 실패] 출금액 : %d, 잔액 : %d #####".formatted(amount, this.balance));
            return false;
        }

        // 출금에 걸리는 시간
        sleep(1000);

        // 잔고 > 출금액
        this.balance -= amount;
        log("##### [출금 성공] 출금액 : %d, 잔액 : %d #####".formatted(amount, this.balance));

        log("##### 거래종료 #####");

        return true;
    }

    @Override
    public int getBalance() {
        return 0;
    }
}
