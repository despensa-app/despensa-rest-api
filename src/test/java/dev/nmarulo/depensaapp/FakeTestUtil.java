package dev.nmarulo.depensaapp;

import net.datafaker.Faker;

public final class FakeTestUtil {
    
    public static final Faker faker;
    
    static {
        faker = new Faker();
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
    
}
