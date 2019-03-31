package tst.jumia.BIN.impl;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tst.jumia.BIN.dto.ValidateMapper;
import tst.jumia.BIN.dto.ValidateStatus;
import tst.jumia.BIN.pojo.Card;

@Component
public class CardInterfaceImpl implements CardInterface {

	@Override
	public String verify(String id) {
		String response = null;
		ValidateStatus myStatus = new ValidateStatus();
		ObjectMapper mapper = new ObjectMapper();
		
		try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet("https://lookup.binlist.net/" + id);
			try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet)) {
				response = EntityUtils.toString(httpResponse.getEntity());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		try {
			if(!response.equalsIgnoreCase("")) {
				Card card = mapper.readValue(response, Card.class);		
				ValidateMapper objectMapper = new ValidateMapper();				
				myStatus = objectMapper.convertToDTO(card);			
				return mapper.writeValueAsString(myStatus);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		myStatus.setSucess(false);
		try {
			response = mapper.writeValueAsString(myStatus);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response;
	}

	@Override
	public String stats(int start, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
