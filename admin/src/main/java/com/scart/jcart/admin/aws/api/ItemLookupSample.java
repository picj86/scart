/* ********************************************************************************************
 *
 *  Amazon Product Advertising API
 *  Signed Requests Sample Code
 *
 *  API Version: 2009-03-31
 *
 */
package com.scart.jcart.admin.aws.api;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/*
 * This class shows how to make a simple authenticated ItemLookup call to the
 * Amazon Product Advertising API.
 * 
 * See the README.html that came with this sample for instructions on
 * configuring and running the sample.
 */
public class ItemLookupSample {
	/*
	 * Your AWS Access Key ID, as taken from the AWS Your Account page.
	 */
	private static final String AWS_ACCESS_KEY_ID = "XXX";

	/*
	 * Your AWS Secret Key corresponding to the above ID, as taken from the AWS
	 * Your Account page.
	 */
	private static final String AWS_SECRET_KEY = "XXX";
	
	/*
	 * Your Associate Tag key
	 */
	
	private static final String AWS_ASSOCIATE_TAG_KEY = "XXX";
	/*
	 * Use one of the following end-points, according to the region you are
	 * interested in:
	 * 
	 * US: ecs.amazonaws.com CA: ecs.amazonaws.ca UK: ecs.amazonaws.co.uk DE:
	 * ecs.amazonaws.de FR: ecs.amazonaws.fr JP: ecs.amazonaws.jp
	 * 
	 */
	private static final String ENDPOINT = "ecs.amazonaws.in";

	/*
	 * The Item ID to lookup. The value below was selected for the US locale.
	 * You can choose a different value if this value does not work in the
	 * locale of your choice.
	 */
	private static final String ITEM_ID = "B01BYBU24W";

	public static void main(String[] args) {
		/*
		 * Set up the signed requests helper
		 */
		SignedRequestsHelper helper;
		try {
			helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY, AWS_ASSOCIATE_TAG_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		String requestUrl = null;
		String title = null;

		/*
		 * The helper can sign requests in two forms - map form and string form
		 */

		/*
		 * Here is an example in map form, where the request parameters are
		 * stored in a map.
		 */
		System.out.println("Map form example:");
		Map<String, String> params = new HashMap<String, String>();
		params.put("Service", "AWSECommerceService");
		params.put("Version", "2009-03-31");
		params.put("AssociateTag", AWS_ASSOCIATE_TAG_KEY);
		params.put("Operation", "ItemLookup");
		params.put("ItemId", ITEM_ID);
		params.put("ResponseGroup", "Small");

		requestUrl = helper.sign(params);
		System.out.println("Signed Request is \"" + requestUrl + "\"");

		title = fetchTitle(requestUrl);
		System.out.println("Signed Title is \"" + title + "\"");
		System.out.println();

		/*
		 * Here is an example with string form, where the requests parameters
		 * have already been concatenated into a query string.
		 */
		System.out.println("String form example:");
		String queryString = "Service=AWSECommerceService&Version=2009-03-31&Operation=ItemLookup&ResponseGroup=Small&ItemId="
				+ ITEM_ID;
		requestUrl = helper.sign(queryString);
		System.out.println("Request is \"" + requestUrl + "\"");

		title = fetchTitle(requestUrl);
		System.out.println("Title is \"" + title + "\"");
		System.out.println();

	}

	/*
	 * Utility function to fetch the response from the service and extract the
	 * title from the XML.
	 */
	private static String fetchTitle(String requestUrl) {
		String title = null;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(requestUrl);
			Node titleNode = doc.getElementsByTagName("Title").item(0);
			
			title = titleNode.getTextContent();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return title;
	}

}
