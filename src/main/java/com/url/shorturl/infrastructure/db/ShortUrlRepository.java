package com.url.shorturl.infrastructure.db;

import com.url.shorturl.domain.ShortUrl;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ShortUrlRepository {
    private Map<Long, ShortUrl> mappingShortUrl = new HashMap<>();
    private Long sequence = 0L;

    public ShortUrl save(ShortUrl mappingUrl) {
        mappingUrl.setId(++sequence);
        mappingShortUrl.put(sequence, mappingUrl);
        return mappingUrl;
    }

}
