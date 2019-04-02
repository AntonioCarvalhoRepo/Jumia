package tst.jumia.BIN.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Payload {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="schema")
	private String schema;
	@Column(name="type")
	private String type;
	@Column(name="bank")
	private String bank;
}
