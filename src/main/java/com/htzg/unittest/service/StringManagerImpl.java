package com.htzg.unittest.service;

/**
 * ClassName StringManagerImpl
 * Description TODO
 *
 * @Date 2019/1/30 10:37
 * Version 1.0
 */
public class StringManagerImpl implements StringManager {

    @Override
    public String connect(String a, String b) {
        return a + b;
    }
}
