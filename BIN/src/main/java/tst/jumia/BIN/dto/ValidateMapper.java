package tst.jumia.BIN.dto;

import tst.jumia.BIN.pojo.Card;

public class ValidateMapper {

	public CardSchemaDTO convertToDTO(Card card) {
		CardSchemaDTO newStatus = new CardSchemaDTO();
		
		if(card != null) {
			PayloadDTO newPayload = new PayloadDTO();
			newPayload.setType(card.getType());		
			newPayload.setSchema(card.getScheme());
			newPayload.setBank(card.getBank().getName());
			newStatus.setSuccess(true);
			newStatus.setPayload(newPayload);
			
			return newStatus;
		}
		
		newStatus.setSuccess(false);
		
		return newStatus;
	}

}
