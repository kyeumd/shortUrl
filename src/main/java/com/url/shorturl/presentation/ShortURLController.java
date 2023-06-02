package com.url.shorturl.presentation;

import com.url.shorturl.application.FindUrlProcessor;
import com.url.shorturl.application.MakeShortUrl;
import com.url.shorturl.application.data.MappingUrlData;
import com.url.shorturl.application.data.ShortUrlData;
import com.url.shorturl.presentation.request.MakeShortUrlRequest;
import com.url.shorturl.presentation.response.MakeShortUrlResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShortURLController {

    private final MakeShortUrl makeShortUrl;
    private final FindUrlProcessor findUrlProcessor;

    @ResponseBody
    @PostMapping("/make/shorturl")
    public HttpEntity<MakeShortUrlResponse> makeShortUrl(@RequestBody MakeShortUrlRequest makeUrlRequest) {
        log.info("make short url");
        log.info(makeUrlRequest.originUrl());

        ShortUrlData shortUrlData = makeShortUrl.makeUrl(makeUrlRequest);

        return new HttpEntity<>(MakeShortUrlResponse.from(shortUrlData));
    }

    @GetMapping("/{shortUrl}")
    public String redirectUrl(@PathVariable String shortUrl) {
        log.info("redirect url");
        log.info(shortUrl);

        MappingUrlData redirectUrl = findUrlProcessor.findUrl(shortUrl);
        log.info("origin url : " + redirectUrl.originUrl());
        return "redirect:" + redirectUrl.originUrl();
    }
}
