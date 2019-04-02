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

import tst.jumia.BIN.dto.CardSchemaDTO;
import tst.jumia.BIN.dto.ValidateMapper;
import tst.jumia.BIN.pojo.Card;

@Component
public class CardInterfaceImpl implements CardInterface {
	
	@Override
	public CardSchemaDTO verify(String id) {
		String response = null;
		ObjectMapper mapper = new ObjectMapper();
		
		CardSchemaDTO myDTO = new CardSchemaDTO();
		myDTO.setSuccess(false);
		
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
				return objectMapper.convertToDTO(card);			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			response = mapper.writeValueAsString(myDTO);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return myDTO;
	}

	@Override
	public CardSchemaDTO stats(int start, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
