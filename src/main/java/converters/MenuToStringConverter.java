package converters;

import org.springframework.core.convert.converter.Converter;

import domain.Menu;


public class MenuToStringConverter implements Converter<Menu, String>{

	@Override
	public String convert(Menu admin) {
		String result;

		if (admin == null)
			result = null;
		else
			result = String.valueOf(admin.getId());

		return result;
	}
}
