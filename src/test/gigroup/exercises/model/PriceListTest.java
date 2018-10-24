package gigroup.exercises.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import gigroup.exercises.myshop.model.Price;
import gigroup.exercises.myshop.model.PriceList;

public class PriceListTest {

	private final Price priceInstance = new Price.PriceBuilder().build();

	@Test(expected = UnsupportedOperationException.class)
	public final void cantModifyEmptyPriceList() {
		final PriceList priceList = new PriceList.PriceListBuilder().build();
		final List<Price> list = priceList.getPrices();
		list.add(priceInstance);
	}

	@Test(expected = UnsupportedOperationException.class)
	public final void cantModifyCustomPriceList() {
		final List<Price> prices = new ArrayList<Price>();
		prices.add(priceInstance);
		final PriceList priceList = new PriceList.PriceListBuilder().withPrices(prices).build();
		final List<Price> unmodifiableList = priceList.getPrices();
		unmodifiableList.add(priceInstance);
	}

}
