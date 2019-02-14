package com.htzg.unittest.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringManagerImplTest {

    @Autowired
    private StringManager stringManager;

    private int testInt = 0;

    @DisplayName("基于环境变量的条件测试")
    @DisabledIfEnvironmentVariable(named = "ENV_TEST", matches = ".*development.*")
    @Test
    void connect() {
    }

    @DisplayName("重复测试10次，基于JavaScript表达式的测试")
    @RepeatedTest(11)
    @EnabledIf("Math.random() < 0.314159")
    @Test
    void connect2(TestReporter reporter) {
        reporter.publishEntry(String.valueOf(testInt));
        assertEquals(2, 1 + 1);
    }

    @DisplayName("重复测试，默认为per method的生命周期")
    @RepeatedTest(10)
    void connect3(TestReporter reporter){
        testInt++;
        reporter.publishEntry(String.valueOf(testInt));
    }

    @DisplayName("参数化测试，数据源为字符串")
    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    void connect4(String srcString, TestReporter reporter) {
        String result = stringManager.connect("a", srcString);
        reporter.publishEntry(result);
    }

    @DisplayName("参数化测试，数据源为静态工厂方法")
    @ParameterizedTest
    @MethodSource("stringProvidor")
    void connect5(String srcString, TestReporter testReporter){
        String result = stringManager.connect("a", srcString);
        testReporter.publishEntry(result);
    }

    static Stream<String> stringProvidor(){
        return Stream.of("cat", "dog", "mouse");
    }
}