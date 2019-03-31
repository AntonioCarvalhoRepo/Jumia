package tst.jumia.BIN.entity;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@DynamicUpdate
@Data
public class CardSchema {
	@Id
	private long id;	
	@Column(name="schema")
	private String schema;
	@Column(name="type")
	private String type;
	@Column(name="bank")
	private String bank;
	
	
}
