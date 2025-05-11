# 1. 가벼운 OpenJDK 17 slim 버전 사용
FROM openjdk:17-jdk-slim

# 2. 이미지 작성자 정보 추가 (선택 사항)
LABEL maintainer="pej4303@gmail.com"

# 3. 컨테이너 내부에서 사용할 포트 개방
EXPOSE 8080

# 4. 애플리케이션 JAR 파일을 컨테이너에 복사하기 위한 변수 정의
ARG JAR_FILE=build/libs/portfolio-pej-0.0.1-SNAPSHOT.jar

# 5. JAR 파일을 컨테이너 내부의 `portfolio-pej.jar`로 복사
COPY ${JAR_FILE} portfolio-pej.jar

# 6. 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/portfolio-pej.jar"]