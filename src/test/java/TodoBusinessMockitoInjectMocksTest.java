package mockitoExample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessMockitoInjectMocksTest {

	@Mock
	TodoService todoServiceMock;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Test
	public void testRetreiveTodosRelatedToSpring_usingAMock() {
		//Given
		
		/* 
		 * TodoService todoServiceMock = mock(TodoService.class);
		 * Removed because of @Mock 
		*/
		List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
		/*
		 * when-thenRetuen
		 * given-willReturn
		 * 
		 */
		
		given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
		
		/*
		 * TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		 */
		
		//When
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		
		//Then
		assertThat(filteredTodos.size(), is(2));
		
		assertEquals("Learn Spring MVC", filteredTodos.get(0));
		assertEquals("Learn Spring", filteredTodos.get(1));
	}
	
	
	@Test
	public void testRetreiveTodosRelatedToSpring_withEmptyList() {
		
		/*
		TodoService todoServiceMock = mock(TodoService.class);
		Removed because of @Mock
		*/
		List<String> todos = Arrays.asList();
		when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);
		
		/*
		 * TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
		 */
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(0, filteredTodos.size());
		
//		assertEquals("Learn Spring MVC", filteredTodos.get(0));
//		assertEquals("Learn Spring", filteredTodos.get(1));
	}

}
