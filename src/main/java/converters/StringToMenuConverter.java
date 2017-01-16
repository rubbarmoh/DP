package converters;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import domain.Menu;

import repositories.MenuRepository;

public class StringToMenuConverter implements Converter<String, Menu>{

	@Autowired
	MenuRepository menuRepository;

	@Override
	public Menu convert(String text) {
		Menu result;
		int id;

		try {
			if(StringUtils.isEmpty(text)){
				result=null;
			}else{
				id = Integer.valueOf(text);
				result = menuRepository.findOne(id);
			}
		} catch (Exception oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}
	
}
