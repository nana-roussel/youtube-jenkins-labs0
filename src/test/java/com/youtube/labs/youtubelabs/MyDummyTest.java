package com.youtube.labs.youtubelabs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyDummyTest {

    @Test
    public void assertThatOnePlusOneIsTwo () {
        int somme = 1 +1;
        assertThat(somme).isNotNull();
        assertThat(somme).isEqualTo(2);
    }

    @Test
    public void assertThatOnePlusTwoIsThree () {
        int somme = 2 +1;
        assertThat(somme).isNotNull();
        assertThat(somme).isEqualTo(2);
    }

}
