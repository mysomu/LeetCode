import pandas as pd

def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:

    employees.loc[
        (employees['employee_id'] % 2 == 0) |
        (employees['name'].str.startswith('M')),
        'salary'
    ] = 0

    employee_bonus = employees[['employee_id', 'salary']].rename(
        columns={'salary': 'bonus'}
    )

    employee_bonus = employee_bonus.sort_values(by='employee_id')

    return employee_bonus