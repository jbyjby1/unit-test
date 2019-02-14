package com.htzg.unittest.service;

import org.springframework.stereotype.Service;


/**
 * ClassName Calculator
 * Description 计算类
 *
 * @Date 2019/1/30 10:19
 * Version 1.0
 */
@Service
public class CalculatorImpl implements Calculator{

    /**
     * 返回两个数的和
     * @param a
     * @param b
     * @return
     */
    @Override
    public int add(int a, int b){
        return a + b;
    }

}
