package my.example.project;

import net.jqwik.api.*;

public class JqwikProperties {
  @Property(tries = 10)
  @Label("my jqwik property")
  boolean test(@ForAll int i) {
    return true;
  }
}
