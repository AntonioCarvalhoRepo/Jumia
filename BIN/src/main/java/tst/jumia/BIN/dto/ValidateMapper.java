package tst.jumia.BIN.dto;

import tst.jumia.BIN.pojo.Card;

public class ValidateMapper {

	public ValidateStatus convertToDTO(Card card) {
		ValidateStatus newStatus = new ValidateStatus();
		
		if(card != null) {
			Payload newPayload = new Payload();
			newPayload.setType(card.getType());		
			newPayload.setScheme(card.getScheme());
			newPayload.setBank(card.getBank().getName());
			newStatus.setSucess(true);
			newStatus.setPayload(newPayload);
			
			return newStatus;
		}
		
		newStatus.setSucess(false);
		
		return newStatus;
	}

}
