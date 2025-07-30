package kuke.board.article.config;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

@Slf4j
public class JasyptEncryptorTest {
    @Test
    void test() {
        String jasyptKey = "1111";  // 암호화 키

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        encryptor.setAlgorithm("PBEWithMD5AndDES");
        encryptor.setPassword(jasyptKey);

        String plainText = "test";
        String encryptedText = encryptor.encrypt(plainText);

        log.info("ENC({})", encryptedText);
    }
}
