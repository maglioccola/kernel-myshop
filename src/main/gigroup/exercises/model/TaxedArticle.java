package gigroup.exercises.model;

import java.math.BigDecimal;

public class TaxedArticle extends Article implements Taxable {

	private final BigDecimal taxPercent = new BigDecimal(10);

	@Override
	public BigDecimal getTaxPercent() {
		return taxPercent;
	}
}
