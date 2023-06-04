package com.url.shorturl.infrastructure.db;

import com.url.shorturl.domain.ShortUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
@Component
public class ShortUrlRepository {
    private static ConcurrentMap<Long, ShortUrl> mappingShortUrl = new ConcurrentHashMap<>();
    private Long sequence = 0L;

    public ShortUrl save(ShortUrl mappingUrl) {

        mappingUrl.setId(++sequence);
        mappingShortUrl.put(sequence, mappingUrl);
        log.info("Repo save // mapping Url info :  " + mappingUrl.toString());
        return mappingUrl;
    }

}
