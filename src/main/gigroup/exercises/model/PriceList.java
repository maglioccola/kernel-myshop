package gigroup.exercises.model;

import java.util.Collections;
import java.util.List;

public class PriceList {

	private Long id;
	private List<Price> prices = Collections.emptyList();

	private PriceList() {

	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public List<Price> getPrices() {
		return prices;
	}

	private void setPrices(final List<Price> prices) {
		this.prices = Collections.unmodifiableList(prices);
	}

	public Price getPrice(final Article article) throws Exception {
		if (article == null) {
			throw new Exception("The article cannot be null");
		} else {
			for (final Price price : prices) {
				if (article.getId() == price.getArticle().getId()) {
					return price;
				}
			}
		}
		throw new Exception("The article is missing");
	}

	public static class PriceListBuilder {
		private final PriceList instance = new PriceList();

		public PriceListBuilder withId(final Long id) {
			instance.setId(id);
			return this;
		}

		public PriceListBuilder withPrices(final List<Price> prices) {
			instance.setPrices(prices);
			return this;
		}

		public PriceList build() {
			return this.instance;
		}
	}
}
