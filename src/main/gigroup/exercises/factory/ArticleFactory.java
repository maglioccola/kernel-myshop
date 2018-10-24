package gigroup.exercises.factory;

import gigroup.exercises.model.Article;
import gigroup.exercises.model.TaxExemptArticle;
import gigroup.exercises.model.TaxedArticle;

public class ArticleFactory {

	public static Article createArticle(final Long id, final String name) {
		return createArticle(id, name, false, false);
	}

	public static Article createImportedArticle(final Long id, final String name) {
		return createArticle(id, name, true, false);
	}

	public static Article createTaxExemptArticle(final Long id, final String name) {
		return createArticle(id, name, false, true);
	}

	public static Article createTaxExemptImportedArticle(final Long id, final String name) {
		return createArticle(id, name, true, true);
	}

	private static Article createArticle(final Long id, final String name, final boolean isImported,
			final boolean isTaxedExempt) {
		final Article article;
		if (isTaxedExempt) {
			article = new TaxExemptArticle();
		} else {
			article = new TaxedArticle();
		}

		article.setId(id);
		article.setName(name);
		article.setImported(isImported);

		return article;
	}
}
