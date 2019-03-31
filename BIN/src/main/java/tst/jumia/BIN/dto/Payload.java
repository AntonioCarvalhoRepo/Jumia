package tst.jumia.BIN.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Payload {
	@JsonProperty("scheme")
	private String scheme;
	@JsonProperty("type")
	private String type;
	@JsonProperty("bank")
	private String bank;
}
