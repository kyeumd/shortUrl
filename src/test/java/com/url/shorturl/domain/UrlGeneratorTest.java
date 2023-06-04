package com.url.shorturl.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UrlGeneratorTest {

    @Test
    void gen() {

        assertThat(UrlGenerator.gen(9L)).isEqualTo("9");
        assertThat(UrlGenerator.gen(63L)).isEqualTo("11");
        assertThat(UrlGenerator.gen(345L)).isEqualTo("Z5");

    }
}