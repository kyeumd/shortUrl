package com.url.shorturl.presentation;

import com.url.shorturl.application.FindUrlProcessor;
import com.url.shorturl.application.ShortUrlProcessor;
import com.url.shorturl.application.data.MappingUrlData;
import com.url.shorturl.application.data.ShortUrlData;
import com.url.shorturl.presentation.request.MakeShortUrlRequest;
import com.url.shorturl.presentation.response.MakeShortUrlResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShortURLController {

    private final ShortUrlProcessor shortUrlProcessor;
    private final FindUrlProcessor findUrlProcessor;

    @ResponseBody
    @PostMapping("/shortUrl")
    public HttpEntity<MakeShortUrlResponse> makeShortUrl(
        @RequestBody MakeShortUrlRequest makeUrlRequest) {
        log.info("make short url // origin : " + makeUrlRequest.originUrl());

        ShortUrlData shortUrlData = shortUrlProcessor.makeUrl(makeUrlRequest);

        return new HttpEntity<>(MakeShortUrlResponse.from(shortUrlData));
    }

    @GetMapping("/{shortUrl}")
    public String redirectUrl(@PathVariable String shortUrl) {
        log.info("redirect url // shortUrl : " + shortUrl);

        MappingUrlData redirectUrl = findUrlProcessor.findUrl(shortUrl);
        log.info("origin url : " + redirectUrl.originUrl());
        return "redirect:" + redirectUrl.originUrl();
    }
}
