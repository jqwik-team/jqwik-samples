package my.example.project;

import net.jqwik.api.*;

class JqwikProperties {
  @Property
  boolean my_jqwik_property(@ForAll int i) {
    return true;
  }
}
