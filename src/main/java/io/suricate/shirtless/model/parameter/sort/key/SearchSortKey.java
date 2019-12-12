package io.suricate.shirtless.model.parameter.sort.key;

/**
 * Base interface for a Sort Key.
 * <br/><br/>
 * Instances will have: <br/>
 * Label: What this sort key represents. Consider placing a human readable description. <br/>
 * Code: To be used on the translation of the {@link io.suricate.shirtless.model.parameter.sort.SearchSortParameters}. Should be a unique per member. <br/>
 * Value: What this sort key sends to other layers to be used. Eg. Spring needs an object property path. <br/>
 * <br/><br/>
 *
 */
public interface SearchSortKey {

	/**
	 * Gets the Sort Key label. <br/>
	 * Such label should be Human readable and convey what this sort key represents.
	 *
	 * @return Sort Key label value.
	 */
	String getLabel();

	/**
	 * Gets the Sort Key Code. <br/>
	 * Such code will be used on the translation from code to Sort Key.
	 *
	 * @return Sort Key Code value.
	 */
	String getCode();

	/**
	 * Gets the Sort Key Value. <br/>
	 * Such value is what will be used by other layers when processing this Sort Key. <br/>
	 * Such value should vary depending on what the downstream expects. <br/>
	 * Eg. Spring needs to sort by an Object Property Path, Lucene needs a document field.
	 *
	 * @return Sort Key Value.
	 */
	String getValue();

}
