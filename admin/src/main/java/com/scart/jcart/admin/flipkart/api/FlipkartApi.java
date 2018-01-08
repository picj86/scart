package com.scart.jcart.admin.flipkart.api;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.jayway.jsonpath.internal.path.ArrayPathToken;

public class FlipkartApi {

	private DataParser parser;
	private String affiliateId = "XXX";
	private String affiliateToken = "XXX";
	private String downloadType = "JSON";

	public FlipkartApi() {	}

	public FlipkartApi(String downloadType) {
		this.downloadType = downloadType;
	}

	public FlipkartApi(String affiliateId, String affiliateToken, String downloadType) {
		this.affiliateId = affiliateId;
		this.affiliateToken = affiliateToken;
		this.downloadType = downloadType;
	}

	public List<ProductInfo>  getProductsList(String categoryqueryUrl) throws AffiliateAPIException{
		List<ProductInfo> products=null;
		parser = new JSONDataParser(affiliateId, affiliateToken);
		products = parser.getProductListByCategoy(categoryqueryUrl);
			
		return products;
	}
	public Map<String, String> getCategoryList(){
		System.out.println("getCategoryList");
		Map<String, String> categories =null;
		parser = new JSONDataParser(affiliateId, affiliateToken);
		
		try {
			if (parser.initializeProductDirectory()) {
				categories = parser.getProductDirectory();
			} else {
				System.out.println("Unable to contact the Flipkart Affiliate API service.");
			}
		} catch (AffiliateAPIException e) {
			System.out.println("API Exception raised: " + e.getMessage());
		}
		
		return categories;
	}
	public DataParser getParser() {
		return parser;
	}

	public void setParser(DataParser parser) {
		this.parser = parser;
	}

	public String getAffiliateId() {
		return affiliateId;
	}

	public void setAffiliateId(String affiliateId) {
		this.affiliateId = affiliateId;
	}

	public String getAffiliateToken() {
		return affiliateToken;
	}

	public void setAffiliateToken(String affiliateToken) {
		this.affiliateToken = affiliateToken;
	}

	public String getDownloadType() {
		return downloadType;
	}

	public void setDownloadType(String downloadType) {
		this.downloadType = downloadType;
	}

	@Override
	public String toString() {
		return "FlipkartApi [parser=" + parser + ", affiliateId=" + affiliateId + ", affiliateToken=" + affiliateToken
				+ ", downloadType=" + downloadType + "]";
	}

	public static void main(String args[]) {
		FlipkartApi feeds = new FlipkartApi();
		
		
		/*try {
			String[] ary = new String[] {"SHIEHPTN8WMHJPGY, WIPEFNWNWBA2ZCGW"};
			for(String s : ary){
				System.out.println("product id: " + s);
			}
			List<ProductInfo> products = feeds.getParser().getProductListById("SHIEGMXDC82GYYHG");
			
			for(ProductInfo product:products){
				System.out.println("Title: " + product.getTitle());
			}
			
		} catch (AffiliateAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			
			// Query the API service to get the list of categories and the
			// corresponding URLs and store it
			// locally in productDirectory Map.
			if (feeds.getParser().initializeProductDirectory()) {

				System.out.println("Choose one of the categories:");
				// Get the list of categories from the locally stored
				// productDirectory Map.
				Iterator<String> category_iterator = feeds.getParser().getProductDirectory().keySet().iterator();
				
				while (category_iterator.hasNext()) {
					System.out.println(category_iterator.next());
				}
				System.out.print("Enter a category (or type 'q' to quit): ");
				
				Scanner s = new Scanner(System.in);
				String category="baby_care";

				do {
					category = s.nextLine();
					if (category.equalsIgnoreCase("q")) {
						return;
					}

					if (!feeds.getParser().getProductDirectory().keySet().contains(category)) {
						System.out.print("Enter a valid category (or type 'q' to quit): ");
					} else {
						break;
					}
				} while (Boolean.TRUE);

				int count = 0;
				// Get a list of products for the given category.
				Iterator<ProductInfo> products_iterator = feeds.getParser().getProductList(category).listIterator();
				while (products_iterator.hasNext()) {
					ProductInfo product = products_iterator.next();
					if (product.isInStock()) {
						// Some of the fields are printed.
						System.out.println("Title: " + product.getTitle());
						System.out.println("URL: " + product.getProductUrl());
						System.out.println("Price: " + product.getMrp() + "\n\n");
						count++;
					}
				}

				System.out.println("Found " + count + " products in " + category + " category.\n\n");
			} else {
				System.out.println("Unable to contact the Flipkart Affiliate API service.");
			}
		} catch (AffiliateAPIException e) {
			System.out.println("API Exception raised: " + e.getMessage());
		}
	}

}
