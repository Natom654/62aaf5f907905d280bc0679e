package ua.ithillel;

import junit.framework.TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import ua.ithillel.array.ArrayafterFour;
import ua.ithillel.array.MethodForArrayContains14;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.platform.engine.discovery.ClassNameFilter.includeClassNamePatterns;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class TestRunner {

    @Test
    @DisplayName("Test name contains String")
    public void TestNameofClassContainsString() {
    }

    @Test
    @DisplayName("Test name contains name of Class")
    public void TestNameofClass(TestInfo testinfo) {
        assertEquals("SimpleMathLibrary", testinfo.getTestClass());
    }

    SummaryGeneratingListener listener = new SummaryGeneratingListener();

    public void runOne() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(SimpleMathLibrary.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }

    public void runAll() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage("ua.ithillel"))
                .filters(includeClassNamePatterns(".*Test"))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);
    }

    @RunWith(Suite.class)
    @SuiteClasses({ArrayafterFour.class, MethodForArrayContains14.class})

    public class JUnitTestSuite {
        public static void printMe() {
            System.out.println("JUnitTestSuite is the test suite grouping ArrayafterFour and MethodForArrayContains14");
        }
    }
}
