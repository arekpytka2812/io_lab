package Test.Mocked;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@RunWith(Categories.class)
@Categories.IncludeCategory({MockedTest.class})
@Categories.SuiteClasses({
        SendReplacementBusMockedTest.class,
        LineMockedTest.class,
        UserAuthMockedTest.class
})


public class SuiteMocked {
}
