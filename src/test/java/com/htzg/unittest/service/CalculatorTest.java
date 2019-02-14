package com.htzg.unittest.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("计算类单元测试")
public class CalculatorTest {

    Logger logger = LoggerFactory.getLogger(CalculatorTest.class);

    @Autowired
    Calculator calculator;

    @BeforeEach
    void setUp() {
        logger.info("before each");
    }

    @DisplayName("计算1+1=2")
    @Tag("hello world")
    @Test
    void add(TestReporter testReporter) {
        int onePlusOne = calculator.add(1, 1);
        assertEquals(2, onePlusOne);
        logger.info("test success");
        testReporter.publishEntry("1", "1");
    }
}