package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.CriticRepository;
import repositories.UserRepository;


import domain.Critic;
import domain.User;

@Component
@Transactional
public class StringToCriticConverter implements Converter<String,Critic>{
	@Autowired
	CriticRepository criticRepository;

	@Override
	public Critic convert(String text) {
		Critic result;
		int id;

		try {
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id = Integer.valueOf(text);
				result = criticRepository.findOne(id);
			}
		} catch (Exception oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
