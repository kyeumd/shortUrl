package com.url.shorturl.infrastructure.db;

import com.url.shorturl.domain.ShortUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;
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

    public static Optional<String> findUrlByShortUrl(String shortUrl) {
        Optional<String> originString = mappingShortUrl.values().stream()
                .filter(urlRepo -> shortUrl.equals(urlRepo.getShortUrl()))
                .findFirst()
                .map(ShortUrl::getOriginUrl);
        log.info("Repo origin : " + originString.toString());
        return originString;
    }

    public ShortUrl updateShortUrl(ShortUrl shortUrl) {
        ShortUrl savedShortUrl = mappingShortUrl.get(shortUrl.getId());
        savedShortUrl.setShortUrl(shortUrl.getShortUrl());
        return savedShortUrl;
    }
}
