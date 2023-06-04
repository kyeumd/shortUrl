package com.url.shorturl.domain;

import com.url.shorturl.domain.base62.ConstBase62;

public class UrlEncoder {
    public static String gen(Long id) {

        return genShortUrl(id);

    }

    private static String genShortUrl(Long id) {
        StringBuilder shortUrl = new StringBuilder();
        Long tempID = id;
        do {
            int index = (int) (tempID % 62);
            shortUrl.append(ConstBase62.base62Chars[index]);
            tempID /= 62;
        } while (tempID >= 1);

        return String.valueOf(shortUrl);
    }
}
