package enumeration;

public enum Confirm {
    Y(10, 1),
    N(20, 0);

    private int flag1;
    private int flag2;

    Confirm(int flag1, int flag2) {
        this.flag1 = flag1;
        this.flag2 = flag2;
    }
}
