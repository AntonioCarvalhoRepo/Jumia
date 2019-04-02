package tst.jumia.BIN.entity;

import org.springframework.stereotype.Component;

import tst.jumia.BIN.dto.CardSchemaDTO;

@Component
public class CardEntityMapper {
	
	public CardSchema save(CardSchemaDTO returnableDTO) {
		CardSchema newCard = new CardSchema();
		
		if(returnableDTO != null) {
			Payload newPayload = new Payload();
			newPayload.setType(returnableDTO.getPayload().getType());		
			newPayload.setSchema(returnableDTO.getPayload().getSchema());
			newPayload.setBank(returnableDTO.getPayload().getBank());
			newCard.setPayload(newPayload);
			
			return newCard;
		}
		return newCard;
	}
}
