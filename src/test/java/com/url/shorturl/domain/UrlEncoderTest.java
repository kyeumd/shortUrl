package com.url.shorturl.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UrlEncoderTest {

    @Test
    void gen() {

        assertThat(UrlEncoder.gen(9L)).isEqualTo("9");
        assertThat(UrlEncoder.gen(63L)).isEqualTo("11");
        assertThat(UrlEncoder.gen(345L)).isEqualTo("Z5");

    }
}