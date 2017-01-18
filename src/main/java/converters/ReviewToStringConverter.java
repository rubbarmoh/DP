package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Actor;
import domain.Critic;
import domain.Review;

@Component
@Transactional
public class ReviewToStringConverter implements Converter<Review, String>{
	
	@Override
	public String convert(Review review) {
		String result;

		if (review == null)
			result = null;
		else
			result = String.valueOf(review.getId());

		return result;
	}

}
