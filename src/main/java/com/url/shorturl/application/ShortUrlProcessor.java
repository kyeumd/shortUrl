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
public class ShortUrlProcessor {
    private final ShortUrlRepository mappingUrlInfoRepository;

    public ShortUrlData makeUrl(MakeShortUrlRequest makeUrlRequest) {

        //todo-기존재 origin url 인지 체크하는 부분 필요 -> findUrl


        ShortUrl newShortUrl = mappingUrlInfoRepository.save(new ShortUrl(null, makeUrlRequest.originUrl(), null));
        ShortUrl mappingShortUrl = ShortUrl.makeShortUrl(newShortUrl);
        ShortUrl savedShortUrl = mappingUrlInfoRepository.updateShortUrl(mappingShortUrl);
        
        return ShortUrlData.from(savedShortUrl);
    }
}
