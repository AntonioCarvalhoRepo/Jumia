package tst.jumia.BIN.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ValidateStatus {
	@JsonProperty("sucess")
	private boolean sucess;
	@JsonProperty("payload")
	private Payload payload;
}
