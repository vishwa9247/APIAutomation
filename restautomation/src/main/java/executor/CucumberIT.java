package executor;

import io.cucumber.core.cli.Main;
import org.junit.jupiter.api.Test;

public class CucumberIT
{
    @Test
    void executor()
    {
        Main.run( new String[] {
                "--threads", "1",
                "-p", "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "-g", "stepsdefs", "src/main/resources",
//                "-t", "@POSTScenario1", "@Scenario3"
                "-t", "@POSTScenario1"
        },CucumberIT.class.getClassLoader() );
    }
}
