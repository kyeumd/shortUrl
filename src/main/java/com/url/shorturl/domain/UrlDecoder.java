package com.url.shorturl.domain;

import com.url.shorturl.domain.base62.ConstBase62;

public class UrlDecoder {
    public static long decodeUrl(String shortUrl) {

        String[] shortUrlarr = shortUrl.split("");
        String base62CharsString = String.valueOf(ConstBase62.base62Chars);
        long id = 0L;

        for (int i = 0; i < shortUrl.length(); i++) {
            id += base62CharsString.indexOf(shortUrlarr[i]) * (i == 0 ? 1 : 62L * i);
        }
        return id;
    }

}
