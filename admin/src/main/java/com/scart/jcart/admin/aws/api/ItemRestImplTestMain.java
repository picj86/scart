/**
 * 
 */
package com.scart.jcart.admin.aws.api;

import java.util.Arrays;
import java.util.List;

import com.scart.jcart.admin.aws.models.rest.Item;
import com.scart.jcart.admin.aws.models.rest.SearchItemsResults;

/**
 * @author pj0014676
 *
 */
/**
 * 
 * Common ItemSearch Parameters
 * Availability
 * BrowseNode
 * Condition
 * Keywords
 * MaximumPrice
 * MinimumPrice
 * Title
 * 
 * Best Practices:
 * Use the Sort parameter to return results in a specific order, 
 * such as from most to least expensive. For more information, 
 * see Sort by Popularity, Price, or Condition.
 * 
 * 
 *
 */
public class ItemRestImplTestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ItemRestImpl obj = new ItemRestImpl();
		
		// Response Group
		/*<ResponseGroup>BrowseNodes</ResponseGroup>
        <ResponseGroup>Images</ResponseGroup>
        <ResponseGroup>ItemAttributes</ResponseGroup>
        <ResponseGroup>Offers</ResponseGroup>
        <ResponseGroup>OfferSummary</ResponseGroup>
        <ResponseGroup>Reviews</ResponseGroup>
        <ResponseGroup>Small</ResponseGroup>*/
        
		//Item item = obj.lookup("B06ZXWWD6R");
		
		
	//	System.out.println("Item-> " + item.toString());
		
		SearchItemsResults search = obj.searchItems("", Arrays.asList(new String[] {"Images", "Offers","OfferSummary","Reviews","Small" }), "Baby", 1, "1571275031", false);
		System.out.println("huhh.. " + search);
		System.out.println("Total Page: " + search.getTotalPages());
		List<Item> list = search.getItems();
		for(Item item : list){
			System.out.println("SKU: " + item.getAsin());
			System.out.println("Title: " + item.getItemAttributes().getTitle());
			System.out.println("List Price: " + item.getItemAttributes().getListPrice());
			System.out.println("Qty: " + item.getOfferSummary().getTotalNew());
			System.out.println("Price: " + item.getOfferSummary().getLowestNewPrice().getFormattedPrice());
			System.out.println("Detailed URL: " + item.getDetailPageURL());
			//if(item.getSmallImage().getUrl()==null)
			//	System.out.println("Image URL: " + item.getSmallImage().getUrl());
			System.out.println("----------------------------------------------");
			
		}

	}

}
