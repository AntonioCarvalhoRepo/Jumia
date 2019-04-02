package tst.jumia.BIN.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PayloadDTO {
	@JsonProperty("schema")
	private String schema;
	@JsonProperty("type")
	private String type;
	@JsonProperty("bank")
	private String bank;
}
