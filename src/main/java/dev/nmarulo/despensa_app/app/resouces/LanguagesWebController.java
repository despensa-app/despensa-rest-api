package dev.nmarulo.despensa_app.app.resouces;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources/languages")
@RequiredArgsConstructor
@Getter
@Tag(name = "Resources - Languages",
     description = "Endpoint to obtain the texts according to the selected language, for the web application")
public class LanguagesWebController {
    
    private final LanguagesWebService languagesWebService;
    
    @GetMapping
    public ResponseEntity<Object> getLanguages() {
        return ResponseEntity.ok(this.languagesWebService.getByLocale(LocaleContextHolder.getLocale()));
    }
    
}
