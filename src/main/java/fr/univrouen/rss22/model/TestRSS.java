package fr.univrouen.rss22.model;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

public class TestRSS {
	
	public String loadFileXML() {
		ResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource("classpath:xml/item.xml");
		try {
			return asString(resource);
		} catch (IOException e) {
			return "An error occured : " + e.toString();
		}
	}
	
	public String asString(Resource resource) throws IOException  {
		
		try (Reader reader = new InputStreamReader(resource.getInputStream())) 
		{
			return FileCopyUtils.copyToString(reader);
		} catch (IOException e) {
			return "An error occured : " + e.toString();
		}
	}

}
