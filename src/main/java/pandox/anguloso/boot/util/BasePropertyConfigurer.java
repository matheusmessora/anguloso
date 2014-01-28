package pandox.anguloso.boot.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

/**
 * Carrega o arquivo de configurações da aplicação <br>config.properties</br>
 * @author lcsilva
 *
 */
public class BasePropertyConfigurer extends PropertyPlaceholderConfigurer {

	Properties mergedProperties;

	public Properties getMergedProperties() throws IOException {
		if (mergedProperties == null) {
			mergedProperties = mergeProperties();
		}
		return mergedProperties;
	}
}
