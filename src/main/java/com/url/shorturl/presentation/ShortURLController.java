package com.url.shorturl.presentation;

import com.url.shorturl.application.MakeShortUrl;
import com.url.shorturl.application.data.ShortUrlData;
import com.url.shorturl.presentation.request.MakeShortUrlRequest;
import com.url.shorturl.presentation.response.MakeShortUrlResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ShortURLController {

    private final MakeShortUrl makeShortUrl;

    @PostMapping("/make/shorturl")
    public HttpEntity<MakeShortUrlResponse> makeShortUrl(@RequestBody MakeShortUrlRequest makeUrlRequest) {
        log.info("make short url");
        log.info(makeUrlRequest.originUrl());

        ShortUrlData shortUrlData = makeShortUrl.makeUrl(makeUrlRequest);

        return new HttpEntity<>(MakeShortUrlResponse.from(shortUrlData));
    }
}
