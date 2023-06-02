package com.url.shorturl.presentation.response;

import com.url.shorturl.application.data.ShortUrlData;

public record MakeShortUrlResponse(
        String originUrl,
        String shortUrl
) {
    public static MakeShortUrlResponse from(ShortUrlData shortUrlData) {
        return new MakeShortUrlResponse(
                shortUrlData.originUrl(),
                shortUrlData.shortUrl()
        );
    }
}
