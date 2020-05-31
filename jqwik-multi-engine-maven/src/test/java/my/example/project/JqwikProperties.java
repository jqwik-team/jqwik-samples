package my.example.project;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;

public class JqwikProperties {
  @Property(tries = 10)
  @Label("my jqwik property")
  boolean test(@ForAll int i) {
    return true;
  }
}
