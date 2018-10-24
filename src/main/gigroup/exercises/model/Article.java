package gigroup.exercises.model;

import java.math.BigDecimal;

public abstract class Article implements Taxable {

	protected static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

	protected static final BigDecimal IMPORTED_TAX_PERCENT = new BigDecimal(5);

	private Long id;
	private String name;
	private boolean imported = false;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public boolean isImported() {
		return imported;
	}

	public void setImported(final boolean imported) {
		this.imported = imported;
	}

	public abstract BigDecimal getTaxPercent();

	@Override
	public BigDecimal getSalesTaxPercent() {
		final BigDecimal taxPercent;
//		if (this.isImported()) {
//			taxPercent = this.getTaxPercent().add(IMPORTED_TAX_PERCENT);
//		} else {
		taxPercent = this.getTaxPercent();
//		}
		return taxPercent.divide(ONE_HUNDRED);
	}
}
