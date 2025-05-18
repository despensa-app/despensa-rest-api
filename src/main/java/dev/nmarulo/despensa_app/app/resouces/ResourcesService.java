package dev.nmarulo.despensa_app.app.resouces;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResourcesService {
    
    private final ObjectMapper objectMapper;
    
    @SuppressWarnings("unchecked")
    public Map<String, String> getLanguagesByLocale(Locale locale) {
        try {
            final var localeFileName = String.format("lang/web/messages_%s.json", locale.getLanguage());
            var localeResource = new ClassPathResource(localeFileName);
            
            if (!localeResource.exists()) {
                localeResource = new ClassPathResource("lang/web/messages_es.json");
            }
            
            return objectMapper.readValue(localeResource.getInputStream(), Map.class);
        } catch (IOException e) {
            return Collections.emptyMap();
        }
    }
    
}
