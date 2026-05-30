package section08_map.test;

import java.util.HashMap;
import java.util.Map;

/**
 * 문제7 - 장바구니
 *
 * - 문제 설명
 * CartMain 과 실행 결과를 참고해서 Product, Cart 클래스를 완성하자.
 * Cart 클래스는 Map을 통해 상품을 장바구니에 보관한다.
 * Map의 Key는 Product가 사용되고, Value는 장바구니에 담은 수량이 사용된다.
 *
 * 장바구니 추가 - add()
 * 장바구니에 상품과 수량을 담는다.
 * 상품의 이름과 가격이 같으면 같은 상품이다.
 * 장바구니에 이름과 가격이 같은 상품을 추가하면 기존에 담긴 상품에 수량만 추가된다.
 * 장바구니에 이름과 가격이 다른 상품을 추가하면 새로운 상품이 추가된다.
 *
 * 장바구니 추가 - minus()
 * 장바구니에 담긴 상품의 수량을 줄일 수 있다. 만약 수량이 0 이하가 되면 상품이 장바구니에서 제거된다.
 *
 * - 실행 결과
 * ==모든 상품 출력==
 * 상품: Product{name='사과', price=1000} 수량: 1
 * 상품: Product{name='바나나', price=500} 수량: 1
 * ==모든 상품 출력==
 * 상품: Product{name='사과', price=1000} 수량: 3
 * 상품: Product{name='바나나', price=500} 수량: 1
 * ==모든 상품 출력==
 * 상품: Product{name='바나나', price=500} 수량: 1
 */
public class Cart {
    private Map<Product, Integer> cartMap = new HashMap<>();
    // 코드 작성

    public void add(Product product, int price) {
        if (cartMap.containsKey(product)) {
            cartMap.put(product, cartMap.get(product) + price);
        } else {
            cartMap.put(product, price);
        }
    }

    public void minus(Product product, int price) {
        if (cartMap.containsKey(product)) {
            cartMap.put(product, cartMap.get(product) - price);
            // 만약 수량이 0 이하가 되면 상품이 장바구니에서 제거된다.
            if (cartMap.get(product) <= 0) {
                cartMap.remove(product);
            }
        }
    }

    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
            Product product = entry.getKey();
            int price = entry.getValue();

            System.out.println("상품: " + product.toString() + " 수량: " + price);
        }
    }
}
