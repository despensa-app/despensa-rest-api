package dev.nmarulo.depensaapp.commons.gson;

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

        Integer.valueOf(3).compareTo(2)
        new Integer(3).compareTo(2)
        HashMap<URL, Integer> hits = new HashMap<>();
        for (HashMap.Entry<URL, Integer> e : hits) {
            // ... This can become very slow for larger hashmaps of URLS.
        }
        String x = "foo";
        if (x.equals(null)) {
            doSomething();
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
