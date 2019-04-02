package tst.jumia.BIN.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tst.jumia.BIN.dto.CardSchemaDTO;
import tst.jumia.BIN.entity.CardEntityMapper;
import tst.jumia.BIN.entity.CardRepository;
import tst.jumia.BIN.entity.CardSchema;
import tst.jumia.BIN.impl.CardInterfaceImpl;

@RestController
public class CardGateWay {

	@Autowired
	private CardRepository cardRepo;

	@RequestMapping("/card-scheme/verify/{id}")
	public CardSchemaDTO verify(@PathVariable String id) {
		CardInterfaceImpl card = new CardInterfaceImpl();
		CardSchemaDTO returnableDTO = card.verify(id);

		CardEntityMapper myEntityMapper = new CardEntityMapper();
		myEntityMapper.save(returnableDTO);

		cardRepo.save(myEntityMapper.save(returnableDTO));

		return returnableDTO;
	}

	@RequestMapping("/card-scheme/stats")
	public List<CardSchema> stats(@RequestParam int start, @RequestParam int limit) {
		List<CardSchema> cardsTemp = cardRepo.findAll();
		
		for(int i = start; i <= limit; i++) {
			List<CardSchema> cards = cardRepo.findAll();
			cardsTemp.add(cards.get(i));
		}
		return cardsTemp;
		
	}

	@RequestMapping("/card-scheme/repo")
	public List<CardSchema> findPersistedInCardRepo() {
		return cardRepo.findAll();
	}
}
