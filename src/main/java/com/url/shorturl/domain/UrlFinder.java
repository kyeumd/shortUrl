package com.url.shorturl.domain;

import com.url.shorturl.infrastructure.db.ShortUrlRepository;

import java.util.Optional;

public class UrlFinder {
    public Optional<String> findUrl(String shortUrl) {
        return ShortUrlRepository.findUrlByShortUrl(shortUrl);
    }
}
