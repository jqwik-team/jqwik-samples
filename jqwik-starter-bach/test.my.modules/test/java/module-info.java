open /*test-only*/ module test.my.modules {
    requires my.example.project; // module under test
    requires org.assertj.core;
    requires net.jqwik.api;
}
