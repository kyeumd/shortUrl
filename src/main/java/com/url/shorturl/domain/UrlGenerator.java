package com.url.shorturl.domain;

public class UrlGenerator {
    public static String gen(Long id) {

        return genShortUrl(id);

    }

    private static String genShortUrl(Long id) {
        char[] base62Chars = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z'
        };
        StringBuilder shortUrl = new StringBuilder();
        Long tempID = id;
        do {
            int index = (int) (tempID % 62);
            shortUrl.append(base62Chars[index]);
            tempID /= 62;
        } while (tempID >= 1);

        return String.valueOf(shortUrl);
    }
}
