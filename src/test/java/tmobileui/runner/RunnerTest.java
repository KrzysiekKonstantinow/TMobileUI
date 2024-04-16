package tmobileui.runner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features={"classpath:Zadanie1.feature"},
        glue={"classpath:tmobileui/stepdef"}
)

public class RunnerTest {

}