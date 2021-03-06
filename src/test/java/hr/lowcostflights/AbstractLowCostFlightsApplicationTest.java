package hr.lowcostflights;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LowCostFlightsApplication.class)
public abstract class AbstractLowCostFlightsApplicationTest {

	protected Logger log = LoggerFactory.getLogger(AbstractLowCostFlightsApplicationTest.class);

}
