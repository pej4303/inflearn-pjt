package kuke.board.article.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  ENC(...) 같은 암호화된 값을 발견하면  jasyptStringEncryptor 이라는 이름 가진 Bean 찾는다.
 *
 * jasypt-spring-boot는 내부적으로 @ConditionalOnMissingBean(name = "jasyptStringEncryptor") 같은 조건을 통해
 * 이 이름의 빈이 등록되어 있지 않으면 기본 구현체를 자동 생성한다. 하지만 직접 @Bean("jasyptStringEncryptor")을 만들면
 * 그 빈이 우선적으로 사용된다.
 *
 */
@Configuration
public class JasyptConfig {
    @Value("${jasypt.encryptor.password}")
    private String jasyptKey;   // 암호화 키

    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();

        config.setPassword(jasyptKey);  // 암호화 키
        config.setAlgorithm("PBEWithMD5AndDES");  // 알고리즘 설정 (기본값)
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");

        encryptor.setConfig(config);
        return encryptor;
    }
}
