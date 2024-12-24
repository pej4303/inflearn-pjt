package section7;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 7장. 날짜와 시간
 */
public class Section7 {
    public static void main(String[] args) {
        Section7 section7 = new Section7();
//        section7.localDataMain();
        section7.localDateTimeMain();
    }

    /**
     * LocalDate
     */
    public void localDataMain() {
        LocalDate date = LocalDate.now();
        System.out.println("현재 날짜 = " + date);

        // 직접 지정
        LocalDate ofDate = LocalDate.of(2024, 12, 25);
        System.out.println("직접 지정 = " + ofDate);

        // 날짜 계산
        /**
         * 모든 날짜 클래스는 불변이므로 계산시 새로운 결과를 반드시 받아야 함.
         * => 앞에서 불변 객체에 대해 계속 말했던 이유가 이거였음!
         */
        LocalDate plusDay = ofDate.plusDays(100);
        System.out.println("지정 날짜 100일후 = " + plusDay);
    }

    /**
     * LocalTime
     */
    public void localTimeMain() {
        LocalTime time = LocalTime.now();
        System.out.println("현재 시간 = " + time);

        // 직접 지정
        LocalTime ofTime = LocalTime.of(12, 12, 25);
        System.out.println("직접 지정 = " + ofTime);

        // 날짜 계산
        /**
         * 모든 날짜 클래스는 불변이므로 계산시 새로운 결과를 반드시 받아야 함.
         * => 앞에서 불변 객체에 대해 계속 말했던 이유가 이거였음!
         */
        LocalTime plusTime = ofTime.plusHours(1);
        System.out.println("지정 시간 1시간후 = " + plusTime);
    }

    /**
     * LocalDateTime :
     *  LocalDate와 LocalTime을 내부에 가지고 날짜와 시간을 모두 표현한다.
     */
    public void localDateTimeMain() {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println("현재 날짜시간 = " + dt);

        // 직접 지정
        LocalDateTime ofDt = LocalDateTime.of(2025,12,25,1,41,0);
        System.out.println("직접 지정 = " + ofDt);

        // 날짜와 시간을 분리
        LocalDate localDate = ofDt.toLocalDate();
        LocalTime localTime = ofDt.toLocalTime();
        System.out.println("localDate = " + localDate);
        System.out.println("localTime = " + localTime);

        // 날짜와 시간을 합체 => 레고 블록을 조립하는 것처럼 다시 합체 시킬수 있는게 좋은 설계임!
        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println("localDateTime = " + localDateTime);

        // 날짜 계산
        LocalDateTime plusDt = ofDt.plusDays(100);
        System.out.println("직접 지정 100일후 = " + plusDt);
        LocalDateTime plusDt2 = ofDt.plusYears(1);
        System.out.println("직접 지정 1년후 = " + plusDt2);

        // 날짜 비교
        System.out.println("현재 날짜시간 < 직접 지정 날짜시간 : " + dt.isBefore(ofDt));
        System.out.println("현재 날짜시간 > 직접 지정 날짜시간 : " + dt.isAfter(ofDt));
        System.out.println("현재 날짜시간 == 직접 지정 날짜시간 : " + dt.isEqual(ofDt));

        /**
         * isEqual() vs equals()
         * 
         * isEqual() : "시간"만 같은지 확인
         * equals() : 객체의 타입, 타임존 등등이 모두 같아야 함
         */
    }
}
