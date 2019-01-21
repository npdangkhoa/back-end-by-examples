import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@IncludeCategory(C03GoodTestsCategory.class)
@ExcludeCategory(C03BadCategory.class)
@Suite.SuiteClasses({
	A01HelloJUnitTest.class, 
	A01TrackingServiceTests.class
})
public class C03GoodTestsSuite {

}
