package dev.nmarulo.despensa_app;

import net.datafaker.Faker;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

public final class FakeTestUtil {
    
    public static final Faker faker;
    
    static {
        faker = new Faker();
    }

    public static BigDecimal randomBigDecimal(){
        double randomValue = faker.number().randomDouble(2, 1, 1000);
        return BigDecimal.valueOf(randomValue);
    }
    
    public static Integer randomInteger() {
        return faker.random()
                    .nextInt(1, 1000);
    }
    
    public static Long randomLong() {
        return faker.random()
                    .nextLong(1, 1000);
    }
    
    public static String randomWord() {
        return faker.lorem()
                    .word();
    }
    
    public static String randomSentence() {
        return faker.lorem()
                    .sentence(2, 10);
    }
    
    public static String randomEmail() {
        return faker.internet()
                    .emailAddress();
    }
    
    public static String randomPassword() {
        return faker.internet()
                    .password(60, 60);
    }
    
    public static String randomUsername() {
        return faker.internet()
                    .username();
    }
    
    public static String randomImage() {
        return faker.internet()
                    .image();
    }
    
    public static LocalDateTime randomFuture() {
        return LocalDateTime.ofInstant(faker.timeAndDate()
                                            .future(), ZoneId.systemDefault());
    }
    
    public static LocalDateTime randomPast() {
        return LocalDateTime.ofInstant(faker.timeAndDate()
                                            .past(), ZoneId.systemDefault());
    }
}
