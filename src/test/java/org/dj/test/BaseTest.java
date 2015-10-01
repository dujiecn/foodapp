package org.dj.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 集成环境
 * 
 * @author dujie
 *
 */

// XML风格
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextHierarchy({ @ContextConfiguration(name = "parent", locations = "classpath:spring/applicationContext*.xml"),
		@ContextConfiguration(name = "child", locations = "classpath:spring/spring-servlet.xml") })
public abstract class BaseTest {

	@Autowired
	protected WebApplicationContext wac;
	protected MockMvc mockMvc;

	public BaseTest() {
	}

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public abstract void test() throws Exception;

	// @Test
	// public void testView() throws Exception {
	// MvcResult result =
	// mockMvc.perform(MockMvcRequestBuilders.get("/user/login"))
	// .andExpect(MockMvcResultMatchers.view().name("user/view"))
	// .andExpect(MockMvcResultMatchers.model().attributeExists("user"))
	// .andDo(MockMvcResultHandlers.print()).andReturn();

	// Assert.assertNotNull(result.getModelAndView().getModel().get("user"));
	// System.out.println(result.getModelAndView().getModel());
	// }

}