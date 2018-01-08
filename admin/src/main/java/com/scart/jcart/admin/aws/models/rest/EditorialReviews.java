/**
 * 
 */
package com.scart.jcart.admin.aws.models.rest;

/**
 * @author pj0014676
 *
 */
public class EditorialReviews {
	private EditorialReview editorialReview;

	public EditorialReview getEditorialReview() {
		return editorialReview;
	}

	public void setEditorialReview(EditorialReview editorialReview) {
		this.editorialReview = editorialReview;
	}

	@Override
	public String toString() {
		return "EditorialReviews [editorialReview=" + editorialReview + "]";
	}
}
