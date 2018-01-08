/**
 * 
 */
package com.scart.jcart.admin.aws.api;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scart.jcart.admin.aws.models.rest.AmazonUnmarshaller;
import com.scart.jcart.admin.aws.models.rest.Item;
import com.scart.jcart.admin.aws.models.rest.SearchItemsResults;

/**
 * @author Prabhakar Jha
 *
 */
@Service
public class ItemRestImpl implements ItemRest {

	private static final String API_VERSION = "2009-11-01";

	private static final Logger logger = LoggerFactory.getLogger(ItemRestImpl.class);
	
	public ItemRestImpl(){
		init();
	}

	@Autowired
	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private SignedRequestsHelper signedRequestsHelper;

	@Override
	public Item lookup(String asin) {
		String[] responseGroups = { "ItemAttributes", "Offers", "OfferSummary", "Images" };
		return lookup(asin, Arrays.asList(responseGroups), false);
	}

	@Override
	public Item lookup(String asin, List<String> responseGroups) {
		return lookup(asin, responseGroups, false);
	}
	
	public void init(){
		try {
			signedRequestsHelper = SignedRequestsHelper.getInstance("ecs.amazonaws.in", "XX", "XX", "XX");
		} catch (InvalidKeyException | IllegalArgumentException | UnsupportedEncodingException
				| NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public Item lookup(String asin, List<String> responseGroups, Boolean amazonOnly) {
		Map<String, String> params = new TreeMap<String, String>();
		params.put("Service", "AWSECommerceService");
		params.put("Version", API_VERSION);
		params.put("IdType", "ASIN");
		params.put("Condition", "All");
		params.put("Service", "AWSECommerceService");
		params.put("MerchantId", amazonOnly ? "Amazon" : "All");
		params.put("Operation", "ItemLookup");
		params.put("ItemId", asin);
		params.put("ResponseGroup", join(responseGroups, ","));
		
		String url = signedRequestsHelper.sign(params);
		
		logger.debug("URL : " + url);
		
		StreamSource xmlStream = submitRequest(url);

		long start = System.currentTimeMillis();
		// First create a new XMLInputFactory
		// Setup a new eventReader
		Item item = null;
		try {
			item = AmazonUnmarshaller.unmarshalItemLookup(xmlStream);
		} catch (XMLStreamException e) {
			logger.error("XMLStream error", e);
		}
		long end = System.currentTimeMillis();

		logger.debug("Parsing took {} millis", end - start);

		return item;

	}
	
	/** * Multiple ItemIds:
		* In an ItemLookup request, you can include up to ten comma-separated values for ItemId.
	*/

	@Override
	public List<Item> multiLookup(List<String> asins) {
		String[] responseGroups = { "ItemAttributes", "Offers", "OfferSummary", "Images" };
		return multiLookup(asins, Arrays.asList(responseGroups), false);
	}

	@Override
	public List<Item> multiLookup(List<String> asins, List<String> responseGroups) {
		return multiLookup(asins, responseGroups, false);
	}

	@Override
	public List<Item> multiLookup(List<String> asins, List<String> responseGroups, Boolean amazonOnly) {
		
		Map<String, String> params = new TreeMap<String, String>();
		params.put("IdType", "ASIN");
		params.put("Condition", "All");
		params.put("Version", API_VERSION);
		params.put("Service", "AWSECommerceService");
		params.put("MerchantId", amazonOnly ? "Amazon" : "All");
		params.put("Operation", "ItemLookup");
		params.put("ItemId", join(asins, ","));
		params.put("ResponseGroup", join(responseGroups, ","));
		String url = signedRequestsHelper.sign(params);
		
		
		
		StreamSource xmlStream = submitRequest(url);

		long start = System.currentTimeMillis();
		// First create a new XMLInputFactory
		// Setup a new eventReader
		List<Item> items = new ArrayList<Item>();
		try {
			items = AmazonUnmarshaller.unmarshalMultiItemLookup(xmlStream);
		} catch (XMLStreamException e) {
			logger.error("XMLStream error", e);
		}
		long end = System.currentTimeMillis();

		logger.debug("Parsing took {} millis", end - start);

		return items;
	}

	@Override
	public List<Item> searchItems(String keywords) {
		List<String> responseGroups = Arrays.asList(new String[] { "ItemAttributes" });
		return searchItems(keywords, responseGroups);
	}

	@Override
	public List<Item> searchItems(String keywords, List<String> responseGroups) {
		return searchItems(keywords, responseGroups, "All").getItems();
	}

	@Override
	public SearchItemsResults searchItems(String keywords, String searchIndex) {
		List<String> responseGroups = Arrays.asList(new String[] { "ItemAttributes" });
		return searchItems(keywords, responseGroups, searchIndex);
	}

	@Override
	public SearchItemsResults searchItems(String keywords, List<String> responseGroups, String searchIndex) {
		return searchItems(keywords, responseGroups, searchIndex, 1, false);
	}

	@Override
	public SearchItemsResults searchItems(String keywords, List<String> responseGroups, String searchIndex,
			Integer pageNumber, Boolean amazonOnly) {
		Map<String, String> params = new TreeMap<String, String>();
		params.put("Operation", "ItemSearch");
		params.put("SearchIndex", searchIndex);
		params.put("ResponseGroup", join(responseGroups, ","));
		params.put("Keywords", keywords);
		params.put("MerchantId", amazonOnly ? "Amazon" : "All");
		params.put("Availability", "Available");
		params.put("ItemPage", pageNumber.toString());
		params.put("Version", API_VERSION);
		params.put("Service", "AWSECommerceService");
		
		String url = signedRequestsHelper.sign(params);
		
		StreamSource xmlStream = submitRequest(url);

		SearchItemsResults searchItemsResults = null;
		long start = System.currentTimeMillis();
		// First create a new XMLInputFactory
		// Setup a new eventReader
		try {
			searchItemsResults = AmazonUnmarshaller.unmarshalSearchItems(xmlStream);
		} catch (XMLStreamException e) {
			logger.error("XMLStream error", e);
		}
		long end = System.currentTimeMillis();

		logger.debug("Parsing took {} millis", end - start);

		return searchItemsResults;
	}

	/**
	 * Find Item with BrowseNode ID
	 * 
	 * @param keywords
	 * @param responseGroups
	 * @param searchIndex
	 * @param pageNumber
	 * @param browseNode
	 * @param amazonOnly
	 * @return
	 */
	public SearchItemsResults searchItems(String keywords, List<String> responseGroups, String searchIndex,
			Integer pageNumber, String browseNode, Boolean amazonOnly) {
		// Get the Sign in request
		Map<String, String> params = new TreeMap<String, String>();
		params.put("Operation", "ItemSearch");
		params.put("SearchIndex", searchIndex);
		params.put("ResponseGroup", join(responseGroups, ","));
		params.put("Keywords", keywords);
		params.put("Availability", "Available");
		params.put("MerchantId", amazonOnly ? "Amazon" : "All");
		params.put("ItemPage", pageNumber.toString());
		params.put("BrowseNode", browseNode);
		params.put("Version", API_VERSION);
		params.put("Service", "AWSECommerceService");
		
		String url = signedRequestsHelper.sign(params);
		
		StreamSource xmlStream = submitRequest(url);

		SearchItemsResults searchItemsResults = null;
		long start = System.currentTimeMillis();
		// First create a new XMLInputFactory
		// Setup a new eventReader
		try {
			searchItemsResults = AmazonUnmarshaller.unmarshalSearchItems(xmlStream);
		} catch (XMLStreamException e) {
			logger.error("XMLStream error", e);
		}
		long end = System.currentTimeMillis();

		logger.debug("Parsing took {} millis", end - start);

		return searchItemsResults;
	}
	
	/* Search Items with Browse Node & Minimum Percentage Off */
	public SearchItemsResults searchItems(String keywords, List<String> responseGroups, String searchIndex,
			Integer pageNumber, String browseNode, String minPercentageOff, Boolean amazonOnly) {
		Map<String, String> params = new TreeMap<String, String>();
		params.put("Operation", "ItemSearch");
		params.put("SearchIndex", searchIndex);
		params.put("ResponseGroup", join(responseGroups, ","));
		params.put("Keywords", keywords);
		params.put("MerchantId", amazonOnly ? "Amazon" : "All");
		params.put("Availability", "Available");
		params.put("ItemPage", pageNumber.toString());
		params.put("BrowseNode", browseNode);
		params.put("MinPercentageOff", minPercentageOff);
		params.put("Version", API_VERSION);
		params.put("Service", "AWSECommerceService");
		
		String url = signedRequestsHelper.sign(params);
		
		StreamSource xmlStream = submitRequest(url);

		SearchItemsResults searchItemsResults = null;
		long start = System.currentTimeMillis();
		// First create a new XMLInputFactory
		// Setup a new eventReader
		try {
			searchItemsResults = AmazonUnmarshaller.unmarshalSearchItems(xmlStream);
		} catch (XMLStreamException e) {
			logger.error("XMLStream error", e);
		}
		long end = System.currentTimeMillis();

		logger.debug("Parsing took {} millis", end - start);

		return searchItemsResults;
	}
	private StreamSource submitRequest(String url) {
		StreamSource stream = null;
		try {
			stream = restTemplate.getForObject(new URI(url), StreamSource.class);
			
		} catch (URISyntaxException e) {
			logger.error("Error converting string to URL", e);
		} 

		return stream;
	}

	private static String join(List<? extends CharSequence> s, String delimiter) {
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
