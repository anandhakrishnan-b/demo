package com.sangam.demo.mapper;

import org.dozer.loader.DozerBuilder.MappingBuilder;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.TypeMappingOption;

import com.sangam.demo.entity.UserEntity;
import com.sangam.demo.vo.UserVO;

public class UserMappingBuilder extends BeanMappingBuilder{

	@Override
	protected void configure() {
		TypeMappingOption option = new TypeMappingOption() {
			@Override
			public void apply(MappingBuilder arg0) {
				arg0.mapNull(false);
				arg0.trimStrings(true);
				arg0.mapEmptyString(false);
				arg0.wildcard(true);
			}
		};
		
		mapping(UserVO.class, UserEntity.class, option)
			.fields("name", "role.name")
			.fields("type", "role.type")
		;
		
		
	}

}
