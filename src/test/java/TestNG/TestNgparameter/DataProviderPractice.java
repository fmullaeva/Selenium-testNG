package TestNG.TestNgparameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @DataProvider(name="dp-name")
    public Object[][] dpMethod(){

        Object[][] objects = new Object[][]{
                {"First Value"},
                {"Second Value"},
                {"Third value"}
        };
        return objects;
    }
    @Test(dataProvider="dp-name")
    void test(String value){
        System.out.println("Passed Parametr is:"+value);
    }
    @Test(dataProvider = "Customer Info",dataProviderClass = TestData.class)
    void test2(String name,String lastname,int id){
        System.out.println("Name:"+name);
        System.out.println("LastName:"+lastname);
        System.out.println("Id:"+id);
    }
}
