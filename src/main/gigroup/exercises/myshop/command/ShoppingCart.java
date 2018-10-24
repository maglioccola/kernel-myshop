package gigroup.exercises.myshop.command;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import gigroup.exercises.myshop.model.Article;
import gigroup.exercises.myshop.model.Price;
import gigroup.exercises.myshop.model.PriceList;

public class ShoppingCart {

	private final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

	private PriceList priceList;
	private final List<ShoppingCartItem> shoppingCartItems = new ArrayList<ShoppingCartItem>();

	private ShoppingCart() {
	}

	private void setPriceList(final PriceList priceList) {
		this.priceList = priceList;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		BigDecimal totalSalesTaxes = BigDecimal.ZERO;
		BigDecimal total = BigDecimal.ZERO;

		for (final ShoppingCartItem item : shoppingCartItems) {
			try {
				sb.append(item.getQuantity() + " ");
				final Price price = priceList.getPrice(item.getArticle());
				sb.append(price.toString());
				totalSalesTaxes = totalSalesTaxes.add(price.getSalesTax());
				total = total.add(price.getPrice());
			} catch (final Exception e) {
				sb.append(e.getMessage());
			}
			sb.append("\n");
		}

		sb.append("Sales Taxes: ").append(decimalFormat.format(totalSalesTaxes)).append("\n");
		sb.append("Total: ").append(decimalFormat.format(totalSalesTaxes.add(total))).append("\n");
		return sb.toString();
	}

	public void addArticle(final Long quantity, final Article article) {
		this.shoppingCartItems.add(new ShoppingCartItem(quantity, article));
	}

	public static class ShoppingCartBuilder {
		private final ShoppingCart instance = new ShoppingCart();

		public ShoppingCartBuilder withDefaultPriceList() {
			instance.setPriceList(DefaultPriceList.getInstance());
			return this;
		}

		public ShoppingCartBuilder withPriceList(final PriceList priceList) {
			instance.setPriceList(priceList);
			return this;
		}

		public ShoppingCart build() {
			return this.instance;
		}
	}

	class ShoppingCartItem {
		private final Long quantity;
		private final Article article;

		ShoppingCartItem(final Long quantity, final Article article) {
			this.quantity = quantity;
			this.article = article;
		}

		public Long getQuantity() {
			return quantity;
		}

		public Article getArticle() {
			return article;
		}

	}
}
