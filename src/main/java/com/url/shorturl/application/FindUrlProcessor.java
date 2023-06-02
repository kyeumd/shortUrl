package com.url.shorturl.application;

import com.url.shorturl.application.data.MappingUrlData;
import com.url.shorturl.domain.UrlFinder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class FindUrlProcessor {

    public MappingUrlData findUrl(String shortUrl) {
        UrlFinder urlFinder = new UrlFinder();
        Optional<String> finderUrl = urlFinder.findUrl(shortUrl);
        return new MappingUrlData(finderUrl.orElse(""), shortUrl);
    }
}
