package Test;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

@RunWith(Categories.class)
@Categories.IncludeCategory({DatabaseTest.class})
@Categories.SuiteClasses({
        Task2test.class,
        Task3test.class,
        Task4test.class})

public class SuiteDatabase {
}
