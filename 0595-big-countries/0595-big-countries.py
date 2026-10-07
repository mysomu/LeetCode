import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    
    bigCountries_filter = (world['area']>=3000000) | (world['population']>=25000000)

    return  world.loc[bigCountries_filter,['name','population','area']]