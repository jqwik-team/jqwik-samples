package my.example.project;

import net.jqwik.api.*;
import net.jqwik.api.lifecycle.*;
import net.jqwik.spring.*;
import org.springframework.boot.test.context.*;
import org.springframework.test.context.*;

@BootstrapWith(SpringBootTestContextBootstrapper.class)
@AddLifecycleHook(JqwikSpringExtension.class)
class ProjectApplicationTests {

	@Example
	void contextLoads() {
	}

}
