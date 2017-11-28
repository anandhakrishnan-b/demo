package com.sangam.demo;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class ServiceConfig extends WebMvcConfigurerAdapter {

	public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd::MM::yyyy");
	
	@Autowired
	RequestInterceptor requestInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor);
	}
	
	@Bean
	@Primary
	public ObjectMapper serializingObjectMapper() {
	    ObjectMapper objectMapper = new ObjectMapper();
	    //objectMapper.addMixIn(String[].class, DemoJsonIgnoreType.class);
	    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    JavaTimeModule javaTimeModule = new JavaTimeModule();
	    javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
	    javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
	    objectMapper.registerModule(javaTimeModule);
	    return objectMapper;
	}

	public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {
	    @Override
	    public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
	        gen.writeString(value.format(FORMATTER));
	    }
	}
	public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {
	    @Override
	    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
	        return LocalDateTime.parse(p.getValueAsString(), FORMATTER);
	    }
	}
	
}
