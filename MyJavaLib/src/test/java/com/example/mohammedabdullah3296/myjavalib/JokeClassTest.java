package com.example.mohammedabdullah3296.myjavalib;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mohammed El_amary on 2/14/2018.
 */
public class JokeClassTest {
    @Test
    public void test() throws Exception {
        JokeClass joker = new JokeClass();
        assert joker.getJoke().length() != 0;
    }

}