package com.scart.jcart.admin.aws.api;

import java.util.Arrays;
import java.util.List;

import com.scart.jcart.admin.aws.models.rest.Ancestors;
import com.scart.jcart.admin.aws.models.rest.BrowseNode;
import com.scart.jcart.admin.aws.models.rest.BrowseNodes;
import com.scart.jcart.admin.aws.models.rest.Item;
import com.scart.jcart.admin.aws.models.rest.Offer;
import com.scart.jcart.admin.aws.models.rest.SearchBrowseNodesResults;
import com.scart.jcart.admin.aws.models.rest.SearchItemsResults;

public class BrowseNodeImplTestMain {

	public static void main(String[] args) throws InterruptedException {
		BrowseNodeImpl node = new BrowseNodeImpl();
		ItemRestImpl obj = new ItemRestImpl();
		
		
		SearchBrowseNodesResults searchBrowseNodesResults= node.searchBrowseNode("1571272031", Arrays.asList(new String[] {"BrowseNodeInfo"}));
		System.out.println("searchBrowseNodesResults: " + searchBrowseNodesResults);
		
		BrowseNodes browseNodes = searchBrowseNodesResults.getBrowseNodes();
		
		Ancestors root = browseNodes.getAncestors();
		System.out.println("Root Category: " + root.getBrowseNode().getName());
		
		for(int i=1;i<11;i++){
			
			long start = System.currentTimeMillis();
			
			SearchItemsResults search = obj.searchItems("", Arrays.asList(new String[] {"Images", "Offers","OfferSummary","Reviews","Small" }), "Apparel", i, root.getBrowseNode().getBrowseNodeId(), false);
			
			System.out.println("Total Page: " + search.getTotalPages());
			List<Item> list = search.getItems();
			for(Item item : list){
				System.out.println("SKU: " + item.getAsin());
				System.out.println("Title: " + item.getItemAttributes().getTitle());
				System.out.println("List Price: " + item.getItemAttributes().getListPrice());
				System.out.println("Qty: " + item.getOfferSummary().getTotalNew());
				// Get a List of Offer for price
				List<Offer> offers = item.getOffers().getOffers();
				for(Offer offer:offers ){
					if(offer!=null){
						System.out.println("Price: " + offer.getOfferListing().getPrice().getFormattedPrice());
						//System.out.println("Sale Price: " + offer.getOfferListing().getSalePrice().getFormattedPrice());
					}
					
				}
				
					
				System.out.println("Detailed URL: " + item.getDetailPageURL());
				//if(item.getSmallImage().getUrl()==null)
				//	System.out.println("Image URL: " + item.getSmallImage().getUrl());
				System.out.println("----------------------------------------------");
				
			}
			long end = System.currentTimeMillis();
			if((end-start)<1000){
				Thread.sleep(1000); // do nothing for 1000 miliseconds (1 second)
			}
			System.out.println("Parsing took {} millis" + ( end - start));
		}
		List<BrowseNode> browseNode =  searchBrowseNodesResults.getBrowseNodes().getChildren().getBrowseNode();
		
		for(BrowseNode nodes: browseNode){
			System.out.println("Sub Category: " + nodes.getName());
		}
		
	}

}
