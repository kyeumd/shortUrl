package com.url.shorturl.infrastructure.db;

import com.url.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ShortUrlRepository {
    private Map<Long, ShortUrl> mappingShortUrl = new HashMap<>();
    private Long sequence = 0L;

    public ShortUrl save(ShortUrl mappingUrl) {
        mappingUrl.setId(++sequence);
        mappingShortUrl.put(sequence, mappingUrl);
        return mappingUrl;
    }

    public Optional<String> findUrlByOrigin(String originUrl){
        return mappingShortUrl.values().stream()
                .filter(shortUrl -> originUrl.equals(shortUrl.getOriginUrl()))
                .findFirst()
                .map(ShortUrl::getShortUrl);
    }
}
