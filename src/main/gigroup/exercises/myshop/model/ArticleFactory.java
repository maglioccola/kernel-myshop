package gigroup.exercises.myshop.model;

import java.math.BigDecimal;

import gigroup.exercises.myshop.model.Article.ArticleBuilder;

public class ArticleFactory {

	private static final BigDecimal DEFAULT_TAX_PERCENT = new BigDecimal(10);

	/**
	 * Creates a new article.
	 *
	 * @param id          the id
	 * @param name        the name
	 * @param articleType the article type
	 * @return the article
	 */
	public static Article createArticle(final Long id, final String name, final ArticleType articleType) {
		switch (articleType) {
		case Article:
			return createArticle(id, name, false, false);
		case ImportedArticle:
			return createArticle(id, name, true, false);
		case TaxExemptArticle:
			return createArticle(id, name, false, true);
		case TaxExemptImportedArticle:
			return createArticle(id, name, true, true);
		default:
			break;
		}
		return null;
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

	public enum ArticleType {
		Article, ImportedArticle, TaxExemptArticle, TaxExemptImportedArticle
	}
}
