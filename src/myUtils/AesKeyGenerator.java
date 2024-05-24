package myUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AesKeyGenerator {
	
    public static SecretKey generateAESKey(int keyLength) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keyLength); // 128, 192, 또는 256 중 하나의 키 길이 설정
        return keyGen.generateKey();
    }

    public static void main(String[] args) {
        try {
            SecretKey secretKey = generateAESKey(256); //128bit: 128, 256 : 256
            // 생성된 secretKey를 Base64 또는 Hex 등의 형식으로 저장하여 나중에 사용할 수 있습니다.
            byte[] encodedKey = secretKey.getEncoded();
            String base64EncodedKey = java.util.Base64.getEncoder().encodeToString(encodedKey);
            String key32 = base64EncodedKey.substring(0, 32);
            System.out.println("Generated AES Key (Base64): " + key32 + " (size : " + key32.length() + " ) ");
            System.out.println("Generated AES Key (Base64): " + base64EncodedKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
