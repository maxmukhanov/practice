package com.max.practice.excercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BoxSorting {

  public List<String> orderedJunctionBoxes(int numberOfBoxes, List<String> boxList) {

    List<String> newBoxes = new ArrayList<>();
    List<String[]> oldBoxes = new ArrayList<>();

    for (String box : boxList) {
      int ind = box.indexOf(' ');
      if (ind == -1) {
        throw new RuntimeException("invalid box name " + box);
      }

      String id = box.substring(0, ind);
      String version = box.substring(ind).trim();

      if (isAllNumbers(version)) {
        newBoxes.add(box);
      } else {
        oldBoxes.add(new String[]{id, version, box});
      }
    }

    oldBoxes.sort(Comparator.comparing((String[] o) -> o[1]).thenComparing(o -> o[0]));

    List<String> result = new ArrayList<>();
    for (String[] oldBox : oldBoxes) {
      result.add(oldBox[2]);
    }

    result.addAll(newBoxes);


    return result;
  }

  private boolean isAllNumbers(String version) {
    for (int i = 0; i < version.length(); i++) {
      char ch = version.charAt(i);
      if (!Character.isDigit(ch) && ch != ' ') return false;
    }

    return true;
  }
}

