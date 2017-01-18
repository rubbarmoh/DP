package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Actor;
import domain.Critic;

@Component
@Transactional
public class CriticToStringConverter implements Converter<Critic, String>{
	
	@Override
	public String convert(Critic critic) {
		String result;

		if (critic == null)
			result = null;
		else
			result = String.valueOf(critic.getId());

		return result;
	}

}
