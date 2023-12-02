package dev.nmarulo.depensaapp.commons.gson;

import com.google.gson.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @see org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration
 */
@Configuration
public class GsonConfig {
    
    private static final String[] DATE_FORMATS = new String[]{"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssXXX", "yyyy-MM-dd"};
    
    @Bean
    public Gson gson(GsonBuilder gsonBuilder) {
        gsonBuilder.setExclusionStrategies(new GsonExclusionStrategy());
        gsonBuilder.registerTypeAdapter(Timestamp.class, new TimestampTypeAdapter());
        gsonBuilder.registerTypeAdapter(Date.class, new DateTypeAdapter());
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeTypeAdapter());
        
        return gsonBuilder.create();
    }
    
    public static class GsonExclusionStrategy implements ExclusionStrategy {
        
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getAnnotation(GsonExclude.class) != null;
        }
        
        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
        
    }
    
    private static class TimestampTypeAdapter implements JsonDeserializer<Timestamp> {
        
        @Override
        public Timestamp deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            long primitive = json.getAsJsonPrimitive()
                                 .getAsLong();
            
            return new Timestamp(primitive);
        }
        
    }
    
    private static class DateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
        
        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonPrimitive asJsonPrimitive = json.getAsJsonPrimitive();
            
            if (asJsonPrimitive.isNumber()) {
                return new Date(asJsonPrimitive.getAsLong());
            }
            
            String asString = asJsonPrimitive.getAsString();
            
            for (String pattern : DATE_FORMATS) {
                try {
                    return new SimpleDateFormat(pattern).parse(asString);
                } catch (ParseException ignored) {
                }
            }
            
            return null;
        }
        
        @Override
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.getTime());
        }
        
    }
    
    private static class LocalDateTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {
        
        @Override
        public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
        
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString());
        }
        
    }
    
    private static class LocalDateTimeTypeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
        
        @Override
        public LocalDateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            return LocalDateTime.parse(jsonElement.getAsString());
        }
        
        @Override
        public JsonElement serialize(LocalDateTime localDateTime, Type type, JsonSerializationContext jsonSerializationContext) {
            return new JsonPrimitive(localDateTime.toString());
        }
        
    }
    
}
