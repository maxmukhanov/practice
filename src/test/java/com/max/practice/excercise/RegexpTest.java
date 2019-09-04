package com.max.practice.excercise;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpTest {
  private static final Pattern TIBCO_PATTERN = Pattern.compile("([A-Za-z0-9]+)(?=])");


  @Test
  public void regexp() {
    String source = "Queue[Asurion.PRODNA.Q.Business.Persistent.Enterprise.SendCGMessage]";
    Matcher sourceMatcher = TIBCO_PATTERN.matcher(source);
    if (sourceMatcher.find()) {
      System.out.println(sourceMatcher.group());
    } else {
      System.out.println("Does not match");
    }
  }
}
