package hr.lowcostflights.integration.amadeus;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(locations="classpath:amadeus.properties", ignoreUnknownFields=false, prefix="amadeus")
public class AmadeusConfiguration {

	@NotNull
	private String apiKey;

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
}
