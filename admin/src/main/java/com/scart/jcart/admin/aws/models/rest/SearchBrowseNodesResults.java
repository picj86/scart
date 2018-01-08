/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author Prabhakar Jha
 *
 */
public class SearchBrowseNodesResults {

	private BrowseNodes browseNodes = new BrowseNodes();

	public BrowseNodes getBrowseNodes() {
		return browseNodes;
	}

	public void setBrowseNodes(BrowseNodes browseNodes) {
		this.browseNodes = browseNodes;
	}

	@Override
	public String toString() {
		return "SearchBrowseNodesResults [browseNodes=" + browseNodes + "]";
	}
}
