package com.sentrifugo.testData;

import org.testng.annotations.DataProvider;

public class MaritalStatusTest {

    @DataProvider(name="maritalData")
    public Object[][] getData(){
        return new Object[][]{
                {"SS","SSingle","test1"},
                {"MM","MMarried","test2"},
                {"WW","WWidowed","test3"},
                {"DD","DDivorced","test4"}
        };
    }
}
