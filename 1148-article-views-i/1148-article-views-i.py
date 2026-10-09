import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    authors_viewed_own_articles = views[
        views['author_id'] == views['viewer_id']
    ]
    unique_authors = authors_viewed_own_articles[['author_id']].drop_duplicates()
    unique_authors.rename(
        columns={'author_id': 'id'}, 
        inplace=True
    )
    # unique_authors.columns = ['id']
    return unique_authors.sort_values('id')