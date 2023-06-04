package com.url.shorturl.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Getter
@Setter
@ToString
public class ShortUrl {

    private Long id;
    private String originUrl;
    private String shortUrl;

    public ShortUrl(Long id, String originUrl, String shortUrl) {
        this.id = id;
        this.originUrl = originUrl;
        this.shortUrl = shortUrl;
    }

    public static ShortUrl makeShortUrl(ShortUrl shortUrl) {

        String mappingUrl = UrlGenerator.gen(shortUrl.getId());
        shortUrl.setShortUrl(mappingUrl);
        
        return shortUrl;
    }

}
