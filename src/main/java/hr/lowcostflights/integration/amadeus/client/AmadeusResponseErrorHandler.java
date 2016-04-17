package hr.lowcostflights.integration.amadeus.client;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.style.ToStringCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AmadeusResponseErrorHandler implements ResponseErrorHandler {
	
	private static final Logger log = LoggerFactory.getLogger(AmadeusResponseErrorHandler.class);
	
	private static class AmadeusErrorResponse {
		
		private Integer status;
		private String message;
		private String moreInfo;
		
		@Override
		public String toString() {
			ToStringCreator builder = new ToStringCreator(this);
			builder.append("status", status);
			builder.append("message", message);
			builder.append("moreInfo", moreInfo);
			return builder.toString();
		}
	}
	
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		HttpStatus.Series series = response.getStatusCode().series();
        return (HttpStatus.Series.CLIENT_ERROR.equals(series)
                || HttpStatus.Series.SERVER_ERROR.equals(series));
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        AmadeusErrorResponse errorResponse = mapper.readValue(IOUtils.toString(response.getBody(), "UTF-8"),
                AmadeusErrorResponse.class);
        log.info(errorResponse.toString());
	}

}
