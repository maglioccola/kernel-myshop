package gigroup.exercises.myshop.model;

import java.math.BigDecimal;

public class Article implements Taxable {

	protected static final BigDecimal ONE_HUNDRED = new BigDecimal(100);
	protected static final BigDecimal IMPORTED_TAX_PERCENT = new BigDecimal(5);

	private Long id;
	private String name;
	private boolean imported = false;
	private BigDecimal taxPercent;

	private Article() {
	}

	Long getId() {
		return id;
	}

	void setId(final Long id) {
		this.id = id;
	}

	String getName() {
		return name;
	}

	void setName(final String name) {
		this.name = name;
	}

	boolean isImported() {
		return imported;
	}

	void setImported(final boolean imported) {
		this.imported = imported;
	}

	BigDecimal getTaxPercent() {
		return taxPercent;
	}

	void setTaxPercent(final BigDecimal taxPercent) {
		this.taxPercent = taxPercent;
	}

	static class ArticleBuilder {
		private final Article instance = new Article();

		public ArticleBuilder withId(final Long id) {
			instance.setId(id);
			return this;
		}

		public ArticleBuilder withName(final String name) {
			instance.setName(name);
			return this;
		}

		public ArticleBuilder withImported(final boolean imported) {
			instance.setImported(imported);
			return this;
		}

		public ArticleBuilder withTaxPercent(final BigDecimal taxPercent) {
			instance.setTaxPercent(taxPercent);
			return this;
		}

		public Article build() {
			return this.instance;
		}
	}

	@Override
	public BigDecimal getSalesTaxPercent() {
		return this.taxPercent.divide(ONE_HUNDRED);
	}

}
