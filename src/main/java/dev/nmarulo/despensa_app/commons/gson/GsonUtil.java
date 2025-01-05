package dev.nmarulo.despensa_app.commons.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GsonUtil {
    
    private final Gson gson;
    
    public <R> R convertTo(Object object, Class<?> clazz) {
        String json = gson.toJson(object);
        boolean isList = ResolvableType.forClass(List.class)
                                       .isAssignableFrom(ResolvableType.forInstance(object));
        
        if (isList) {
            return fromJsonTo(json, TypeToken.getParameterized(List.class, clazz));
        }
        
        return fromJsonTo(json, TypeToken.get(clazz));
    }
    
    public <R> R fromJsonTo(String json, Class<?> clazz) {
        return fromJsonTo(json, TypeToken.get(clazz));
    }
    
    private <R> R fromJsonTo(String json, TypeToken<?> typeToken) {
        return gson.fromJson(json, typeToken.getType());
    }
    
    public void toJson(Object object, Appendable writer) {
        this.gson.toJson(object, writer);
    }
    
}
