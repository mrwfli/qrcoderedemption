package com.dksh.qrcoderedemption;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class QrcoderedemptionApplicationTests {

	@Test
	void contextLoads() {
	}

//	@Test
//	public void givenNameOfFieldIsChanged_whenSerializing_thenCorrect()
//			throws JsonParseException, IOException {
//		ObjectMapper mapper = new ObjectMapper();
//		MyDtoFieldNameChanged dtoObject = new MyDtoFieldNameChanged();
//		dtoObject.setStringValue("a");
//
//		String dtoAsString = mapper.writeValueAsString(dtoObject);
//
//		assertThat(dtoAsString, not(containsString("stringValue")));
//		assertThat(dtoAsString, containsString("strVal"));
//	}

}
