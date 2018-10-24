package gigroup.exercises.myshop.model;

import java.math.BigDecimal;

import gigroup.exercises.myshop.model.Article.ArticleBuilder;

public class ArticleFactory {

	private static final BigDecimal DEFAULT_TAX_PERCENT = new BigDecimal(10);

	/**
	 * Creates a new article, not imported and not taxed exempt.
	 *
	 * @param id   the id
	 * @param name the name
	 * @return the article
	 */
	public static Article createArticle(final Long id, final String name) {
		return createArticle(id, name, false, false);
	}

	/**
	 * Creates a new imported article, not taxed exempt.
	 *
	 * @param id   the id
	 * @param name the name
	 * @return the article
	 */
	public static Article createImportedArticle(final Long id, final String name) {
		return createArticle(id, name, true, false);
	}

	/**
	 * Creates a new taxed exempt article, not imported.
	 *
	 * @param id   the id
	 * @param name the name
	 * @return the article
	 */
	public static Article createTaxExemptArticle(final Long id, final String name) {
		return createArticle(id, name, false, true);
	}

	/**
	 * Creates a new taxed exempt and imported article.
	 *
	 * @param id   the id
	 * @param name the name
	 * @return the article
	 */
	public static Article createTaxExemptImportedArticle(final Long id, final String name) {
		return createArticle(id, name, true, true);
	}

	/**
	 * Creates a new Article object.
	 *
	 * @param id            the id
	 * @param name          the name
	 * @param isImported    the is imported
	 * @param isTaxedExempt the is taxed exempt
	 * @return the article
	 */
	private static Article createArticle(final Long id, final String name, final boolean isImported,
			final boolean isTaxedExempt) {
		final ArticleBuilder builder = new Article.ArticleBuilder();
		builder.withId(id).withName(name).withImported(isImported);
		if (isTaxedExempt) {
			builder.withTaxPercent(BigDecimal.ZERO);
		} else {
			builder.withTaxPercent(DEFAULT_TAX_PERCENT);
		}

		return builder.build();
	}
}
