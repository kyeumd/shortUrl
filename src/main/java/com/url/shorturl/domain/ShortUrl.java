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

    public ShortUrl(Long id, String originUrl) {
        this.id = id;
        this.originUrl = originUrl;
    }

    public static ShortUrl makeUrl(String originUrl) {

        String mappingUrl = UrlGenerator.gen();

        return new ShortUrl(
                null,
                originUrl
        );

    }

}
