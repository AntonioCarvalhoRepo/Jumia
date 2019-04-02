package tst.jumia.BIN;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tst.jumia.BIN.entity.CardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BinApplicationTests {
	
	@Autowired
	private CardRepository repository;

	@Test
	public void dataIsNotNull() throws Exception {
		assertThat(repository.count() > 0);
	}
	
	@Test
	public void findCardDataInRepo() throws Exception {
		assertThat(repository.findAll());
	}

}
