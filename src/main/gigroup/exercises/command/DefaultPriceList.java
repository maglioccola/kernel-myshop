package gigroup.exercises.command;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import gigroup.exercises.factory.ArticleFactory;
import gigroup.exercises.model.Article;
import gigroup.exercises.model.Price;
import gigroup.exercises.model.PriceList;

public class DefaultPriceList {

	// Input 1 items
	private static final Long BOOK_ID = 100L;
	private static final Long MUSIC_CD_ID = 110L;
	private static final Long CHOCOLATE_BAR_ID = 120L;

	private static final String BOOK_NAME = "book";
	private static final String MUSIC_CD_NAME = "music cd";
	private static final String CHOCOLATE_BAR_NAME = "chocolate bar";

	// Input 2 items
	private static final Long IMP_BOX_CHOCCOLATES_ID = 200L;
	private static final Long IMP_BOTTLE_OF_PERFUME_ID = 210L;

	private static final String IMP_BOX_CHOCCOLATES_NAME = "imported box of chocolates";
	private static final String IMP_BOTTLE_OF_PERFUME_NAME = "imported bottle of perfume";

	// Input 3 items
	private static final Long BOTTLE_OF_PERFUME_ID = 300L;
	private static final String BOTTLE_OF_PERFUME_NAME = "bottle of perfum";

	private static final Long HEADACHE_PILLS_ID = 310L;
	private static final String HEADACHE_PILLS_NAME = "packet of headache pills";

	private DefaultPriceList() {
	}

	public static Article BOOK = ArticleFactory.createTaxExemptArticle(BOOK_ID, BOOK_NAME);
	public static Article MUSIC_CD = ArticleFactory.createArticle(MUSIC_CD_ID, MUSIC_CD_NAME);
	public static Article CHOCOLATE_BAR = ArticleFactory.createTaxExemptArticle(CHOCOLATE_BAR_ID, CHOCOLATE_BAR_NAME);

	public static Article IMP_BOX_CHOCCOLATES = ArticleFactory.createTaxExemptImportedArticle(IMP_BOX_CHOCCOLATES_ID,
			IMP_BOX_CHOCCOLATES_NAME);
	public static Article IMP_BOTTLE_OF_PERFUME = ArticleFactory.createImportedArticle(IMP_BOTTLE_OF_PERFUME_ID,
			IMP_BOTTLE_OF_PERFUME_NAME);

	public static Article BOTTLE_OF_PERFUME = ArticleFactory.createArticle(BOTTLE_OF_PERFUME_ID,
			BOTTLE_OF_PERFUME_NAME);
	public static Article HEADACHE_PILLS = ArticleFactory.createTaxExemptArticle(HEADACHE_PILLS_ID,
			HEADACHE_PILLS_NAME);
	public static Article IMPORTED_BOX_CHOCCOLATES = ArticleFactory
			.createTaxExemptImportedArticle(IMP_BOX_CHOCCOLATES_ID, IMP_BOX_CHOCCOLATES_NAME);

	public static PriceList getInstance() {
		final List<Price> prices = new ArrayList<Price>();

		// Input 1 items
		prices.add(new Price.PriceBuilder().withArticle(BOOK).withPrice(new BigDecimal(12.49)).build());
		prices.add(new Price.PriceBuilder().withArticle(MUSIC_CD).withPrice(new BigDecimal(14.99)).build());
		prices.add(new Price.PriceBuilder().withArticle(CHOCOLATE_BAR).withPrice(new BigDecimal(0.85)).build());

		// Input 2 items
		prices.add(new Price.PriceBuilder().withArticle(IMP_BOX_CHOCCOLATES).withPrice(new BigDecimal(10)).build());
		prices.add(
				new Price.PriceBuilder().withArticle(IMP_BOTTLE_OF_PERFUME).withPrice(new BigDecimal(47.50)).build());

		// Input 3 items
		prices.add(new Price.PriceBuilder().withArticle(BOTTLE_OF_PERFUME).withPrice(new BigDecimal(18.99)).build());
		prices.add(new Price.PriceBuilder().withArticle(HEADACHE_PILLS).withPrice(new BigDecimal(9.75)).build());

		return new PriceList.PriceListBuilder().withPrices(prices).build();
	}

}
