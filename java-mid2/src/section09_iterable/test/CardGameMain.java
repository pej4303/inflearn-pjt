package section09_iterable.test;

import java.util.*;

public class CardGameMain {
    public static void main(String[] args) {
        // 코드 작성
        List<Card> deck = new ArrayList<>();      // 카드목록
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();

        Map<String, Integer> suitOrder = Map.of(
            "♠", 1,
            "♥", 2,
            "♦", 3,
            "♣", 4
        );

        for (String suit : suitOrder.keySet()) {
            for (int i=1; i<=13; i++) {
                deck.add(new Card(i, suit));
            }
        }

        // 카드 섞기
        Collections.shuffle(deck);

        Deque<Card> deque = new ArrayDeque<>(deck);

        // 각 플레이어는 덱에서 카드를 5장씩 뽑는다.
        for (int i=1; i<=10; i++) {
            if (i % 2 == 0) {
                player1.add(deque.poll());
            } else {
                player2.add(deque.poll());
            }
        }

        player1.sort(
            Comparator.comparingInt(Card::getNumber)
                      .thenComparingInt(card -> suitOrder.get(card.getSuit()))
        );
        int player1Sum = player1.stream().mapToInt(Card::getNumber).sum();

        player2.sort(
                Comparator.comparingInt(Card::getNumber)
                        .thenComparingInt(card -> suitOrder.get(card.getSuit()))
        );
        int player2Sum = player2.stream().mapToInt(Card::getNumber).sum();

        System.out.println("플레이어1의 카드:"  +  player1 +", 합계: " + player1Sum);
        System.out.println("플레이어2의 카드:"  +  player2 +", 합계: " + player2Sum);

        if (player1Sum > player2Sum) {
            System.out.println("플레이어1 승리");
        } else if (player1Sum < player2Sum) {
            System.out.println("플레이어2 승리");
        } else {
            System.out.println("무승부");
        }
    }
}
