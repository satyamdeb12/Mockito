package mockitoExample;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TodoBusinessImplStubTest {

	@Test
	public void testRetreiveTodosRelatedToSpring_usingAStub() {
		TodoService todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
		assertEquals(2, filteredTodos.size());
		
		assertEquals("Learn Spring MVC", filteredTodos.get(0));
		assertEquals("Learn Spring", filteredTodos.get(1));
	}

}
