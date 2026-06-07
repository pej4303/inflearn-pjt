package section06_list.test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    // 코드 작성
    private List<Item> cartList = new ArrayList<>();
    private int totalCart = 0;

    public void addItem(Item item) {
        this.cartList.add(item);
        this.totalCart += item.getTotalPrice();
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");

        for (int i=0; i<cartList.size(); i++) {
            System.out.println("상품명:%s, 합계:%d".formatted(cartList.get(i).getName(), cartList.get(i).getTotalPrice()));
        }

        System.out.println("전체 가격 합:%d".formatted(this.totalCart));
    }
}