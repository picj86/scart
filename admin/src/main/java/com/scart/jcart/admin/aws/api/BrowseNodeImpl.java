/**
 * 
 */
package com.scart.jcart.admin.aws.api;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scart.jcart.admin.aws.models.rest.AmazonUnmarshaller;
import com.scart.jcart.admin.aws.models.rest.SearchBrowseNodesResults;

/**
 * @author Prabhakar Jha
 *
 */
@Service
public class BrowseNodeImpl {

	private static final String API_VERSION = "2009-11-01";

	private static final Logger logger = LoggerFactory.getLogger(ItemRestImpl.class);

	@Autowired
	private SignedRequestsHelper signedRequestsHelper;

	public BrowseNodeImpl() {
		init();
	}

	public void init() {
		try {
			signedRequestsHelper = SignedRequestsHelper.getInstance("ecs.amazonaws.in", "AKIAIWVF2JDZHMUJ7J3Q",
					"az+KaJpNIUqnxuqLvNdRyta+UWNd9YoNBw6B8gda", "shepkartcom-21");
		} catch (InvalidKeyException | IllegalArgumentException | UnsupportedEncodingException
				| NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public SearchBrowseNodesResults searchBrowseNode(String browseNodeId, List<String> responseGroups) {

		Map<String, String> params = new TreeMap<String, String>();
		params.put("Operation", "BrowseNodeLookup");
		params.put("BrowseNodeId", browseNodeId);
		params.put("ResponseGroup", ResponseGroupStreamHelper.join(responseGroups, ","));
		params.put("Version", API_VERSION);
		params.put("Service", "AWSECommerceService");

		String url = signedRequestsHelper.sign(params);

		StreamSource xmlStream = ResponseGroupStreamHelper.submitRequest(url);
		logger.debug("URL : " + url);

		long start = System.currentTimeMillis();
		// First create a new XMLInputFactory
		// Setup a new eventReader
		SearchBrowseNodesResults searchBrowseNodesResults = null;
		try {
			searchBrowseNodesResults = AmazonUnmarshaller.unmarshalBrowseNodeLookup(xmlStream);
		} catch (XMLStreamException e) {
			logger.error("XMLStream error", e);
		}
		long end = System.currentTimeMillis();

		logger.debug("Parsing took {} millis", end - start);

		return searchBrowseNodesResults;
	}
}
