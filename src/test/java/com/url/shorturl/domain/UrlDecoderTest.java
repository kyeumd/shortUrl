package com.url.shorturl.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UrlDecoderTest {


    @Test
    void decodeUrl() {

        assertThat(UrlDecoder.decodeUrl("9")).isEqualTo(9L);
        assertThat(UrlDecoder.decodeUrl("11")).isEqualTo(63L);
        assertThat(UrlDecoder.decodeUrl("Z5")).isEqualTo(345L);

    }

}