package gigroup.exercises;

import java.math.BigDecimal;

import gigroup.exercises.command.DefaultPriceList;
import gigroup.exercises.command.ShoppingCart;
import gigroup.exercises.command.ShoppingCart.ShoppingCartBuilder;
import gigroup.exercises.model.PriceList;

public class App {

	public static void main(final String args[]) {
		final App app = new App();
		app.inputCase1();
		app.inputCase2();
		app.inputCase3();
	}

	private void inputCase1() {
		System.out.println("CASE 1:");
		final ShoppingCartBuilder shoppingCartBuilder = new ShoppingCart.ShoppingCartBuilder();
		shoppingCartBuilder.withDefaultPriceList();
		final ShoppingCart shoppingCart = shoppingCartBuilder.build();
		shoppingCart.addArticle(1L, DefaultPriceList.BOOK);
		shoppingCart.addArticle(1L, DefaultPriceList.MUSIC_CD);
		shoppingCart.addArticle(1L, DefaultPriceList.CHOCOLATE_BAR);
		System.out.println(shoppingCart);
	}

	private void inputCase2() {
		System.out.println("CASE 2:");
		final ShoppingCartBuilder shoppingCartBuilder = new ShoppingCart.ShoppingCartBuilder();
		shoppingCartBuilder.withDefaultPriceList();
		final ShoppingCart shoppingCart = shoppingCartBuilder.build();
		shoppingCart.addArticle(1L, DefaultPriceList.IMPORTED_BOX_CHOCCOLATES);
		shoppingCart.addArticle(1L, DefaultPriceList.IMP_BOTTLE_OF_PERFUME);
		System.out.println(shoppingCart + "\n");
	}

	private void inputCase3() {
		System.out.println("CASE 3:");
		final PriceList customPriceList = DefaultPriceList.getInstance();
		try {
			customPriceList.getPrice(DefaultPriceList.IMP_BOTTLE_OF_PERFUME).setPrice(new BigDecimal(27.99));
			customPriceList.getPrice(DefaultPriceList.IMPORTED_BOX_CHOCCOLATES).setPrice(new BigDecimal(11.25));
		} catch (final Exception e) {
			e.printStackTrace();
			return;
		}
		final ShoppingCartBuilder shoppingCartBuilder = new ShoppingCart.ShoppingCartBuilder();
		shoppingCartBuilder.withPriceList(customPriceList);
		final ShoppingCart shoppingCart = shoppingCartBuilder.build();
		shoppingCart.addArticle(1L, DefaultPriceList.IMP_BOTTLE_OF_PERFUME);
		shoppingCart.addArticle(1L, DefaultPriceList.BOTTLE_OF_PERFUME);
		shoppingCart.addArticle(1L, DefaultPriceList.HEADACHE_PILLS);
		shoppingCart.addArticle(1L, DefaultPriceList.IMPORTED_BOX_CHOCCOLATES);
		System.out.println(shoppingCart + "\n");
	}

}