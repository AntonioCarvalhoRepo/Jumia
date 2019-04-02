package tst.jumia.BIN.impl;

import tst.jumia.BIN.dto.CardSchemaDTO;

public interface CardInterface {
	CardSchemaDTO verify(String id);
	
	CardSchemaDTO stats(int start , int limit);
}
