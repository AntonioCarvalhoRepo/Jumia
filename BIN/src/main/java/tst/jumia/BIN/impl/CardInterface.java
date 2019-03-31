package tst.jumia.BIN.impl;

public interface CardInterface {
	String verify(String id);
	
	String stats(int start , int limit);
}
