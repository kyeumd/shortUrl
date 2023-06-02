package com.url.shorturl.application;


import com.url.shorturl.application.data.ShortUrlData;
import com.url.shorturl.domain.ShortUrl;
import com.url.shorturl.infrastructure.db.ShortUrlRepository;
import com.url.shorturl.presentation.request.MakeShortUrlRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MakeShortUrl {
    private final ShortUrlRepository mappingUrlInfoRepository;

    public ShortUrlData makeUrl(MakeShortUrlRequest makeUrlRequest) {

        ShortUrl newShortUrl = ShortUrl.makeUrl(makeUrlRequest.originUrl());
        ShortUrl saveShortUrl = mappingUrlInfoRepository.save(newShortUrl);

        return ShortUrlData.from(saveShortUrl);
    }
}
