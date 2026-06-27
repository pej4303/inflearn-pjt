package section7_synchronized;

public interface BankAccount {
    /**
     * 출금
     * @param amount
     * @return
     */
    boolean withdraw(int amount);

    /**
     * 잔고 확인
     * @return
     */
    int getBalance();
}
