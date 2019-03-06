import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumFromList {

  public long getMaxFromOneItemList() {
    List<Long> longList = new ArrayList<>();
    longList.add(Long.parseLong("1551363994"));

    return longList.stream().max(Comparator.naturalOrder()).get();
  }

}
