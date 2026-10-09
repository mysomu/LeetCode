import pandas as pd

def invalid_tweets(tweets: pd.DataFrame) -> pd.DataFrame:
    # Calculate content length and filter
    invalid = tweets[
        tweets['content'].str.len() > 15
    ]    
    # Return only tweet_id column
    return invalid[['tweet_id']]
    