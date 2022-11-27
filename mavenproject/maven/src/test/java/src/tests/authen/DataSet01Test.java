package src.tests.authen;

import org.testng.annotations.Test;
import src.test_data.models.LoginCred;

import java.util.List;

public class DataSet01Test {

    @Test
    public void testLoginDataSet20(){
        List<LoginCred> loginCredDataSet20 = DataSupporter.loginCredDataSet().subList(0,19);
    }
}
