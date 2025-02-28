package section7;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * 7장. 날짜와 시간
 */
public class Section7 {
    public static void main(String[] args) {
        Section7 section7 = new Section7();
        section7.chronoFieldMain();
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
     * LocalDateTime : LocalDate와 LocalTime을 내부에 가지고 날짜와 시간을 모두 표현한다.
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

    /**
     * ZoneDateTime
     */
    public void zoneIdMain() {
        // 이용가능한 타임존
        for (String availableZoneId : ZoneId.getAvailableZoneIds()) {
            ZoneId zoneId = ZoneId.of(availableZoneId);
            System.out.println(zoneId + " / " + zoneId.getRules());
        }
        
        // 시스템이 사용하는 기본 타임존
        ZoneId systemDefault = ZoneId.systemDefault();
        System.out.println("ZoneId.systemDefault = " + systemDefault);
    }

    /**
     * ZonedDateTime : LocalDateTime + ZoneId 합쳐진 것이다.
     */
    public void zonedDateTimeMain() {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("now = " + now);

        LocalDateTime localDateTime = LocalDateTime.of(2025, 12, 25, 23,37,00);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Asia/Seoul"));
        System.out.println(zonedDateTime);

        // 타임존 변경 (헝가리)
        ZonedDateTime utc1 = zonedDateTime.withZoneSameInstant(ZoneId.of("Europe/Budapest"));
        System.out.println(utc1);
    }

    /**
     * Period, Duration : 시간의 간격을 표현하는데 사용한다.
     *  - Period : 두 날짜 사이의 간격을 년, 월, 일 단위로 표시한다.
     *  - Duration : 두 시간 사이의 간격을 시, 분, 초(나노초) 단위로 나타낸다.
     */
    public void periodMain() {
        Period period = Period.ofDays(10);
        System.out.println("period = " + period);

        // 날짜 계산
        LocalDate curDt = LocalDate.of(2025, 1, 1);
        LocalDate calDt = curDt.plus(period);
        System.out.println("curDt = " + curDt);
        System.out.println("calDt = " + calDt);

        // 날짜 차이 구하기
        LocalDate startDt = LocalDate.of(2025, 1, 1);
        LocalDate endDt = LocalDate.of(2025, 3, 13);
        Period between = Period.between(startDt, endDt);
        System.out.println("between = " + between);


    }

    /**
     * ChronoUnit : 단독으로 사용되지 않고 날짜와 시간 조작시 사용됨
     *  - TemporalUnit 인터페이스 구현체
     */
    public void chronoUnitMain() {
        ChronoUnit[] values = ChronoUnit.values();
        for (ChronoUnit value : values) {
            System.out.println("value = " + value);
        }

        System.out.println("ChronoUnit.HOURS = " + ChronoUnit.HOURS);

        // 시간 차이 구하기
        LocalTime localTime = LocalTime.of(1, 10, 0);
        LocalTime localTime2 = LocalTime.of(1, 20, 0);
        System.out.println("ChronoUnit.MINUTES.between(localTime, localTime2) = " + ChronoUnit.MINUTES.between(localTime, localTime2));
    }

    /**
     * ChronoField : 단독으로 사용되지 않고 날짜와 시간 조작시 사용됨
     *  - TemporalUnit 인터페이스 구현체
     */
    public void chronoFieldMain() {
        ChronoField[] chronoFields = ChronoField.values();
        for (ChronoField chronoField : chronoFields) {
            System.out.println(chronoField + " / range = " + chronoField.range());
        }

        System.out.println("ChronoField.MONTH_OF_YEAR.range() = " + ChronoField.MONTH_OF_YEAR.range());
        System.out.println("ChronoField.DAY_OF_MONTH.range() = " + ChronoField.DAY_OF_MONTH.range());
    }
}
