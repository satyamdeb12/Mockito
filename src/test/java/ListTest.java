package mockitoExample;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import java.awt.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void MockListGetItemMethod() {
		List listMock = mock(List.class);
		when(listMock.getItem(0)).thenReturn("First Element");
		assertEquals("First Element", listMock.getItem(0));
	}
	
	@Test
	public void MockListGetItemMethod_withDiffReturn() {
		List listMock = mock(List.class);
		when(listMock.getItem(0)).thenReturn("First Element").thenReturn("Second Element");
		assertEquals("First Element", listMock.getItem(0));
		assertEquals("Second Element", listMock.getItem(0));
		
		assertEquals(null, listMock.getItem(1)); //default nice mock behaviour

	}	
	
	
	@Test
	public void MockListGetItemMethod_withDiffReturn_anyInt() {
		List listMock = mock(List.class);
		when(listMock.getItem(anyInt())).thenReturn("Element");
		assertEquals("Element", listMock.getItem(0));
		assertEquals("Element", listMock.getItem(1));
		
	}
	
	@Test(expected=RuntimeException.class)
	public void MockListGetItemMethod_withException() {
		List listMock = mock(List.class);
		when(listMock.getItem(anyInt())).thenThrow(RuntimeException.class);
		listMock.getItem(1);
		
	}
	

}
