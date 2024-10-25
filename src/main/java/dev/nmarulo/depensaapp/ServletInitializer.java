package dev.nmarulo.depensaapp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.net.URL;
import java.util.HashMap;

public class ServletInitializer extends SpringBootServletInitializer {
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        Integer.valueOf(3)
               .compareTo(2);
        new Integer(3).compareTo(2);
        HashMap<URL, Integer> hits = new HashMap<>();
        for (HashMap.Entry<URL, Integer> e : hits.entrySet()) {
            // ... This can become very slow for larger hashmaps of URLS.
        }
        String x = "foo";
        if (x.equals(null)) {
            //doSomething();
        }
        Integer value = 1;
        try {
            // ...
        } catch (Exception e) {
            // ...
            value = null; // Value set to null within a catch block
            // ...
        }
        //value.member += 1;
        
        return application.sources(DespensaRestApiApplication.class);
    }
    
}
