package dev.nmarulo.despensa_app.app.resouces;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class LanguagesWebService {
    
    private final ObjectMapper objectMapper;
    
    public Object getByLocale(Locale locale) {
        try {
            final var localeFileName = String.format("lang/web/messages_%s.json", locale.getLanguage());
            var localeResource = new ClassPathResource(localeFileName);
            
            if (!localeResource.exists()) {
                localeResource = new ClassPathResource("lang/web/messages_es.json");
            }
            
            return objectMapper.readValue(localeResource.getInputStream(), Object.class);
        } catch (IOException e) {
            return null;
        }
    }
    
}
