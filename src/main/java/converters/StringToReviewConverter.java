package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.CriticRepository;
import repositories.ReviewRepository;
import repositories.UserRepository;


import domain.Critic;
import domain.Review;
import domain.User;

@Component
@Transactional
public class StringToReviewConverter implements Converter<String,Review>{
	@Autowired
	ReviewRepository reviewRepository;

	@Override
	public Review convert(String text) {
		Review result;
		int id;

		try {
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id = Integer.valueOf(text);
				result = reviewRepository.findOne(id);
			}
		} catch (Exception oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
