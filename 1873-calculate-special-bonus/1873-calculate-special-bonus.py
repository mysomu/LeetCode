import pandas as pd

def calculate_special_bonus(employees: pd.DataFrame) -> pd.DataFrame:
    eligible_for_bonus = (
        (employees['employee_id'] % 2 == 1) &
        (~employees['name'].str.startswith('M'))
    )

    employees['bonus'] = np.where(eligible_for_bonus, employees['salary'], 0)

    return employees[['employee_id', 'bonus']].sort_values(by='employee_id')