/**
 * 
 */
package com.scart.jcart.admin.aws.api;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author pj0014676
 *
 */
public class ResponseGroupStreamHelper {
	private static final Logger logger = LoggerFactory.getLogger(ResponseGroupStreamHelper.class);
		
	//@Autowired
	private static RestTemplate restTemplate = new RestTemplate();
	
	
	
	protected static StreamSource submitRequest(String url) {
		StreamSource stream = null;
		try {
			stream = restTemplate.getForObject(new URI(url), StreamSource.class);
		} catch (URISyntaxException e) {
			logger.error("Error converting string to URL", e);
		}

		return stream;
	}

	protected static String join(List<? extends CharSequence> s, String delimiter) {
		int capacity = 0;
		int delimLength = delimiter.length();
		Iterator<? extends CharSequence> iter = s.iterator();
		if (iter.hasNext()) {
			capacity += iter.next().length() + delimLength;
		}

		StringBuilder buffer = new StringBuilder(capacity);
		iter = s.iterator();
		if (iter.hasNext()) {
			buffer.append(iter.next());
			while (iter.hasNext()) {
				buffer.append(delimiter);
				buffer.append(iter.next());
			}
		}
		return buffer.toString();
	}
}
