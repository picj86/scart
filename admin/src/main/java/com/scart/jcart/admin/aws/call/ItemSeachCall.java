package com.scart.jcart.admin.aws.call;

/**
 * Search Operations for items based on specific parameters such as the
 * category, title, manufacturer, and minimum price. This returns one or more
 * items.
 */
public class ItemSeachCall {

	/**
	 * The ItemSearch operation searches for items on Amazon. The Product
	 * Advertising API returns up to ten items per search results page.
	 * 
	   client.itemSearch({
		  director: 'Quentin Tarantino',
		  actor: 'Samuel L. Jackson',
		  searchIndex: 'DVD',
		  audienceRating: 'R',
		  responseGroup: 'ItemAttributes,Offers,Images'
		}
	 * 
	 * Query params:
	 * You can add any available params for the itemSearch method:

condition: availiable options - 'All', 'New', 'Used', 'Refurbished', 'Collectible'. Defaults to 'All'.

keywords: Defaults to ''

responseGroup: You can use multiple values by separating them with comma (e.g responseGroup: 'ItemAttributes,Offers,Images'). Defaults to'ItemAttributes'

searchIndex: Defaults to 'All'.

itemPage: Defaults to '1'.

sort: Valid values include 'salesrank','psrank','titlerank','-price','price', etc.
	 */

}
