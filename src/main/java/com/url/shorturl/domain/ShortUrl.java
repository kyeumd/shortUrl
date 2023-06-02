package com.url.shorturl.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Setter
public class ShortUrl {

    private Long id;
    private String originUrl;
    private String shortUrl;

    public ShortUrl(Long id, String originUrl, String shortUrl) {
        this.id = id;
        this.originUrl = originUrl;
        this.shortUrl = shortUrl;
    }

    public static ShortUrl makeUrl(String originUrl) {

        String mappingUrl = UrlGenerator.gen();

        return new ShortUrl(
                null,
                originUrl,
                mappingUrl
        );

    }

}
