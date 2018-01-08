/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

import java.util.List;

/**
 * @author pj0014676
 *
 */
public class SearchItemsResults {
	private List<Item> items;
	private int totalPages;
	private int totalResults;

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchItemsResults [items=").append(items).append(", totalPages=").append(totalPages)
				.append(", totalResults=").append(totalResults).append("]");
		return builder.toString();
	}

}
