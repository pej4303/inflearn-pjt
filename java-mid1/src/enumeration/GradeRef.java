package enumeration;

/**
 * 기존 Grade 를 리팩토링했음
 */
public enum GradeRef {
    BASIC(10), GOLD(20), DIAMOND(30);
    private final int discountPercent;
    GradeRef(int discountPercent) {
        this.discountPercent = discountPercent;
    }
    public int getDiscountPercent() {
        return discountPercent;
    }

    /**
     * 할인율 계산
     * @param price
     * @return
     */
    public int discount(int price) {
        return price * discountPercent / 100;
    }

}
