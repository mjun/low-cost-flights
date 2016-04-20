package hr.lowcostflights.web;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import hr.lowcostflights.AbstractLowCostFlightsControllerTest;

@Transactional
public class RestServiceControllerTest extends AbstractLowCostFlightsControllerTest {

	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void testGetAirport() throws Exception {
		String uri = "/airport/ZAG";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP body to have content", content.trim().length() > 0);
	}

	@Test
	public void testFindAirports() throws Exception {
		String uri = "/airport/find?name=AIRPORT";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP body to have content", content.trim().length() > 0);
	}

	@Test
	public void testSearch() throws Exception {
		String uri = "/search?origin=IST&destination=BOS&departure=" + LocalDate.now().plusDays(1).toString()
				+ "&currency=USD";

		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON)).andReturn();

		String content = result.getResponse().getContentAsString();
		int status = result.getResponse().getStatus();

		Assert.assertEquals("failure - expected HTTP status 200", 200, status);
		Assert.assertTrue("failure - expected HTTP body to have content", content.trim().length() > 0);
	}

}
