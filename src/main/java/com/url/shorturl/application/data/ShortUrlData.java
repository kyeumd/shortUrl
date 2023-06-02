package com.url.shorturl.application.data;

import com.url.shorturl.domain.ShortUrl;

public record ShortUrlData(
        Long id,
        String originUrl,
        String shortUrl
) {

    public static ShortUrlData from(ShortUrl shortUrl) {
        return new ShortUrlData(
                shortUrl.getId(),
                shortUrl.getOriginUrl(),
                shortUrl.getShortUrl()
        );
    }
}
