package gigroup.exercises.myshop.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Price {

	protected static final BigDecimal IMPORTED_TAX_PERCENT = new BigDecimal(5);
	
	private static final BigDecimal PRECISION = new BigDecimal(0.05);
	private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

	private Article article;
	private BigDecimal price = BigDecimal.ZERO;

	private Price() {
	}

	private BigDecimal roundCurrency(final BigDecimal value) {
		final BigDecimal rounded = value.divide(PRECISION, 0, RoundingMode.HALF_DOWN).multiply(PRECISION);
		if (rounded.compareTo(value) < 0) {
			return rounded.add(PRECISION);
		}
		return rounded;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(final Article article) {
		this.article = article;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getTaxedIncludedPrice() {
		return price.add(this.getSalesTax());
	}

	public BigDecimal getSalesTax() {
		BigDecimal tax = this.roundCurrency(article.getSalesTaxPercent().multiply(this.price));
		if (article.isImported()) {
			final BigDecimal importedTax = Article.IMPORTED_TAX_PERCENT.multiply(this.price)
					.divide(Article.ONE_HUNDRED);
			tax = tax.add(this.roundCurrency(importedTax));
		}
		return tax;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		if (this.article != null) {
			sb.append(article.getName()).append(": ");
			sb.append(decimalFormat.format(this.getTaxedIncludedPrice()));
		}
		return sb.toString();
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public static class PriceBuilder {
		private final Price instance = new Price();

		public PriceBuilder withArticle(final Article article) {
			instance.setArticle(article);
			return this;
		}

		public PriceBuilder withPrice(final BigDecimal price) {
			instance.setPrice(price);
			return this;
		}

		public Price build() {
			return this.instance;
		}
	}

}
