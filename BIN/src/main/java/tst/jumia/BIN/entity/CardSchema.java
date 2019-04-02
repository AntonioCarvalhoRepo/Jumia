package tst.jumia.BIN.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class CardSchema {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="payload", referencedColumnName="id")
	private Payload payload;	
}
