package interviews.sorts;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class BSTTraversalSortTest {
  @Test
  public void test_random() {
    List<Integer> actuals = Arrays.asList(7, 2, 1, 4, 5, 0, 3, 4, 7, 6);
    BSTTraversalSort.f(actuals, Sorts.getComparatorOfIntegers());
    Assert.assertEquals(Arrays.asList(0, 1, 2, 3, 4, 4, 5, 6, 7, 7), actuals);
  }
}
