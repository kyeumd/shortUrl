package com.url.shorturl.infrastructure.db;

import com.url.shorturl.domain.ShortUrl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Component
public class ShortUrlRepository {
    private static Map<Long, ShortUrl> mappingShortUrl = new HashMap<>();
    private Long sequence = 0L;

    public ShortUrl save(ShortUrl mappingUrl) {

        mappingUrl.setId(++sequence);
        mappingShortUrl.put(sequence, mappingUrl);
        log.info("Repo save");
        log.info("mapping Url info :  " + mappingUrl.toString());
        return mappingUrl;
    }

    public static Optional<String> findUrlByOrigin(String shortUrl) {
        Optional<String> originString = mappingShortUrl.values().stream()
                .filter(urlRepo -> shortUrl.equals(urlRepo.getShortUrl()))
                .findFirst()
                .map(ShortUrl::getOriginUrl);
        log.info("Repo origin : " + originString.toString());
        return originString;
    }
}
