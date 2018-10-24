package gigroup.exercises.model;

import java.math.BigDecimal;

public class TaxExemptArticle extends Article implements Taxable {

	private final BigDecimal defaultTaxPercent = new BigDecimal(0);

	@Override
	public BigDecimal getTaxPercent() {
		return defaultTaxPercent;
	}
}
