package TestNG.TestNgparameter;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name="Customer Info")
    public Object[][]getData(){
    return new Object[][]{
            {"David","Jonhson",123},
            {"sarah","Jonhson",2524},
            {"John","DOe",3456}
    };


}}

