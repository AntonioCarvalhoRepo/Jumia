package tst.jumia.BIN.gateway;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tst.jumia.BIN.impl.CardInterfaceImpl;

@RestController
public class CardGateWay {

  @RequestMapping("/card-scheme/verify/{id}")
  public String verify(@PathVariable String id) {
	  CardInterfaceImpl card = new CardInterfaceImpl();
		
    return card.verify(id);
  }

  @RequestMapping("/card-scheme/stats")
  public String stats(@RequestParam int start, @RequestParam int limit) {
	  return "" + start + "" + limit + "";
  } 
}
