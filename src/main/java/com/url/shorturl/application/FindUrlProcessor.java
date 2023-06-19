package com.url.shorturl.application;

import com.url.shorturl.application.data.MappingUrlData;
import com.url.shorturl.domain.ShortUrl;
import com.url.shorturl.domain.UrlDecoder;
import com.url.shorturl.infrastructure.db.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindUrlProcessor {
    private final ShortUrlRepository mappingUrlInfoRepository;

    public MappingUrlData findUrl(String shortUrl) {

        long id = UrlDecoder.decodeUrl(shortUrl);
        ShortUrl savedShortUrl = mappingUrlInfoRepository.findById(id);
        return new MappingUrlData(savedShortUrl.getOriginUrl(), savedShortUrl.getShortUrl());
    }
}
