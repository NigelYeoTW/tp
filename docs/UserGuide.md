# User Guide
## Introduction

Wiagi is a simple command line application that helps students who are beginning their financial
independence journey by offering a wide range of essential tools and features such as budgeting, saving, 
and investment analysis. 
 
- [Quick start](#Quick-Start)
- [Features](#Features)
  - [Login](#login) 
    - [Creation of new user](#creation-of-new-user)
  - [Adding an entry](#adding-an-entry)
    - [Adding a spending](#adding-a-spending)
    - [Adding an income](#adding-an-income)
  - [Listing all entries](#listing-all-entries)
    - [Listing all spendings](#listing-all-spendings)
    - [Listing all incomes](#listing-all-incomes)
    - [Listing all tags](#listing-all-tags)
    - [Listing all of specific tag](#listing-all-of-specific-tag)
  - [Deleting an entry](#deleting-an-entry)
    - [Deleting an income](#deleting-an-income)
    - [Deleting a spending](#deleting-a-spending)
  - [Getting user instructions](#getting-user-instructions)
  - [Setting a budget](#setting-a-budget)
  - [Editing an entry](#editing-an-entry)
  - [Finding an entry](#finding-an-entry)
  - [Exiting the program](#exiting-the-program)
  - [Saving the data](#saving-the-data)
  - [Editing the data file](#editing-the-data-file)
    - [Format of data storage for password](#format-of-data-storage-for-password)
    - [Format of data storage for income and spending](#format-of-data-storage-for-income-and-spending)
- [FAQ](#faq)
- [Command Summary](#command-summary)

## Quick Start
 
1. Ensure that you have Java 17 or above installed.
2. Down the latest version of `Wiagi` from [here](https://github.com/AY2425S1-CS2113-W14-1/tp/releases/latest).
3. Copy the file to the folder you want to use as the home folder.
4. Open a command terminal, navigate to the folder you have placed the jar file in, 
and use the `java -jar Wiagi.java.jar` command to run the application.
5. You will be prompted to set a password. Set a password and enter the password to log in. 

## Features
> **Notes about the command format:**  
> 
> - Words in `{$UPPER_CASE}` are the parameters to be supplied by the user. <br>
> e.g., in `add spending {$AMOUNT} {$DESCRIPTION}`, `{$AMOUNT}` and `{$DESCRIPTION}` are parameters which 
> can be used as `add spending 4 dinner`.
>  
> - Items in square brackets are optional. <br>
> e.g. `add spending {$AMOUNT} {$DESCRIPTION} [/$DATE/]` can be used as 
> `add spending 4 lunch` or `add spending 4 lunch /2024-10-20/`.

### Login
#### Creation of new user:
First time users will be prompted to create a new password. Users are to type in his/her preferred password.
Subsequent logins will not require this step. <br>
Expected display for first time users:
```
	____________________________________________________________
	Hi! You seem to be new, are you ready?!
	Please enter your new account password:
```
Expected output after successfully creating password: <br>
```
	____________________________________________________________
	Hello from
	__        __  ___      /\       ____   ___
	\ \      / / |_ _|    /  \     / ___| |_ _|
	 \ \ /\ / /   | |    / /\ \   | |  _   | |
	  \ V  V /    | |   / ____ \  | |_| |  | |
	   \_/\_/    |___| /_/    \_\  \____| |___|
	____________________________________________________________
	____________________________________________________________
	Please Enter Login Credentials:
```
*Note that this is also the startup page for returning existing users
### Adding an entry
#### Adding a spending:

Adds an entry into user spending list. Entry will be displayed at the latest index. <br>
Run the [`list spendings`](#listing-all-spendings) command to display the list with the new entry. <br>


**Format:** `add spending {$AMOUNT} {$DESCRIPTION} [/$DATE/] [*$TAG*] [~$FREQUENCY~]`
- `{$AMOUNT}`: Numerical value of the spending, up to 2 decimal places will be taken.
- `{$DESCRIPTION}`: Name of the spending.
- `[/$DATE/]`: Date of the transaction.
  - Must be of YYYY-MM-DD format, eg.`2023-01-21`.
  - If left empty, it would be set to the date of entry.
  - Enclosed in forward slashes.
- `[*$TAG*]`: Label for the entry.
  - Enclosed in asterisks. 
- `[~$FREQUENCY~]`: Frequency of recurrence to automate repeated transactions.
  - Enclosed in tilde.
  - Possible options: `daily`, `monthly` and `yearly`

**Example inputs:** <br>
- `add spending 100 telegram premium` </br>
- `add spending 100 telegram premium /2024-10-20/` </br>
- `add spending 100 telegram premium *personal expense*` </br>
- `add spending 100 telegram premium /2024-10-20/ *personal expense*` </br>
- `add spending 100 telegram premium /2024-10-20/ *personal expense* ~monthly~` </br>

**Expected output:**
```
	____________________________________________________________
	Entry successfully added!
	____________________________________________________________
```

#### Adding an income:

Adds an entry into user income list. Entry will be displayed at the latest index. <br>
Run the [`list incomes`](#listing-all-incomes) command to display the list with the new entry. <br>

**Format:** `add income {$AMOUNT} {$DESCRIPTION} [/$DATE/] [*$TAG*] [~$FREQUENCY~]`
- `{$AMOUNT}`: Numerical value of the income, up to 2 decimal places will be taken.
- `{$DESCRIPTION}`: Name of the income.
- `[/$DATE/]`: Date of the transaction.
  - Must be of YYYY-MM-DD format, eg.`2023-01-21`.
  - If left empty, it would be set to the date of entry.
  - Enclosed in forward slashes.
- `[*$TAG*]`: Label for the entry.
  - Enclosed in asterisks.
- `[~$FREQUENCY~]`: Frequency of recurrence to automate repeated transactions.
  - Enclosed in tilde.
  - Possible options: `daily`, `monthly` and `yearly`

**Example input:** <br>
- `add income 10000 commission` </br>
- `add income 10000 commission /2024-01-01/` </br>
- `add income 10000 commission *bonus*` </br>
- `add income 10000 commission /2024-01-01/ *bonus*` </br>
- `add income 10000 commission /2024-01-01/ *bonus* ~yearly~` </br>

**Expected output:**
```
	____________________________________________________________
	Entry successfully added!
	____________________________________________________________
```

### Listing all entries:

Lists all the entries in the user's spending or income list. <br>
**Format:** `list`

**Example input:** <br>
`list`

**Example output:**
```
	____________________________________________________________
	Spendings
	1. techno - 10 - 2024-10-17 - Tag: food
	2. flights - 10 - 2024-10-17 - Tag: travel
	3. girlfriends - 10 - 2024-10-17 - Tag: personal
	4. macdonalds - 10 - 2024-10-10 - Tag: food
	Total spendings: 40
	Incomes
	1. mcd - 100 - 2024-11-11 - Tag: personal
	2. dividends - 10 - 2024-10-17 - Tag: investment
	Total incomes: 110
	____________________________________________________________
```
#### Listing all spendings:

Lists all the entries in the user's spending list.

**Format:** `list spendings`

The user will then be prompted to select a time range.
Only entries that are within the time range will be displayed.
If option 1 (all) is chosen, the user will then be asked if all spending statistics should be displayed.

**Example Input and Output**

**Input:** `list spendings`
```
	____________________________________________________________
	Select time range:
	[1] All
	[2] Weekly
	[3] Biweekly
	[4] Monthly
```
- **Input:** `1`
  ```
	 ____________________________________________________________
	 List all statistics? [Y/N]:
  ```
    - **Input:** `y`
    ```
        ____________________________________________________________
        Spendings
        1. macdonalds - 10 - 2024-10-10 - food
        2. techno - 10 - 2024-10-17 - food
        3. flights - 10 - 2024-11-01 - travel
        4. girlfriends - 10 - 2024-11-17 - personal
        Total spendings: 40
            Daily spendings: 0
            Daily Budget: 0
            Daily budget left: 0
            Monthly spendings: 40
            Monthly Budget: 0
            Monthly budget left: -40
            Yearly spendings: 40
            Yearly Budget: 0
            Yearly budget left: -40
        ____________________________________________________________
    ```
    - **Input:** `n`
    ```
        ____________________________________________________________
        Spendings
        1. macdonalds - 10 - 2024-10-10 - food
        2. techno - 10 - 2024-10-17 - food
        3. flights - 10 - 2024-11-01 - travel
        4. girlfriends - 10 - 2024-11-17 - personal
        Total spendings: 40
        ____________________________________________________________
    ```
- **Input:** `4` (Date of command is 2024-11-18)
  ```
      ____________________________________________________________
      Spendings
      3. flights - 10 - 2024-11-01 - travel
      4. girlfriends - 10 - 2024-11-17 - personal
      ____________________________________________________________
  ```

#### Listing all incomes:

Lists all the entries in the user's income list.

**Format:** `list incomes`

The user will then be prompted to select a time range. 
Only entries that are within the time range will be displayed.

**Example Input and Output**

**Input:** `list incomes`
```
	____________________________________________________________
	Select time range:
	[1] All
	[2] Weekly
	[3] Biweekly
	[4] Monthly 

```
- **Input:** `1`
  ```
      ____________________________________________________________
      Incomes
      1. mcd - 100 - 2024-11-15 - FastFood
      2. dividends - 10 - 2024-10-17 - investment
      Total incomes: 110
      ____________________________________________________________
  ```

- **Input:** `2` (Date of command is 2024-11-18)
  ```
      ____________________________________________________________
      Incomes
      1. mcd - 100 - 2024-11-15 - FastFood
      ____________________________________________________________
  ```

#### Listing all tags:

Lists all the tags in the user's list.

**Format:** `list tags`

**Example input:** <br>
`list tags`

**Example output:**
```
	____________________________________________________________
	Tags
	1. FastFood
	2. food
	3. investment
	4. personal
	5. travel
	____________________________________________________________
```

#### Listing all of specific tag:

Lists all the entries in the user's list with the specified tag.

**Format:** `list tags {$TAGNAME}`

**Example input:** <br>
`list tags food`

**Example output:**
```
	____________________________________________________________
	Tag: food
	Spendings
	1. techno - 10 - 2024-10-17 - food
	4. macdonalds - 10 - 2024-10-10 - food
	____________________________________________________________
```

### Deleting an entry
#### Deleting an income:
Deletes the specified income from the list. 
The income to delete is specified by its index.<br>
Run the [`list incomes`](#listing-all-incomes) command to check the index of the income.

**Format:** `delete income {$INDEX}`

**Example input:** <br>
`delete income 1`

**Example output:**
```
    ____________________________________________________________
        Successfully deleted!
    ____________________________________________________________
```

#### Deleting a spending:
Deletes the specified spending from the list.
The spending to delete is specified by its index.<br>
Run the [`list spendings`](#listing-all-spendings) command to check the index of the spending.

**Format:** `delete spending {$INDEX}`

**Example input:** <br>
`delete spending 1`

**Example output:**
```
    ____________________________________________________________
    Successfully deleted!
    ____________________________________________________________
```

### Getting user instructions

The `help` command allows the user to see a quick summary of the commands.

**Format:** `help`

**Example input:**<br>
`
help
`

**Example output**:
```
Notes about the command format:
Words in {$UPPER_CASE} are the parameters to be supplied by the user.
e.g., in add spending {$AMOUNT} {$DESCRIPTION}, {$AMOUNT} and {$DESCRIPTION}
are parameters which can be used as add spending 4 dinner.
Items in square brackets are optional.
e.g. add spending {$AMOUNT} {$DESCRIPTION} [/$DATE/] can be used as
add spending 4 lunch or add spending 4 lunch /2024-10-20/.

Adding Entries:
	add income {$AMOUNT} {$DESCRIPTION} [/$DATE/] [*$TAG*] [~$FREQUENCY~]
	add spending {$AMOUNT} {$DESCRIPTION} [/$DATE/] [*$TAG*] [~$FREQUENCY~]
	e.g., add income 5000 Salary /2024-03-15/ *work* ~monthly~
	e.g., add spending 50 Lunch /2024-03-15/ *food*

Listing Entries:
	list - shows all entries
	list incomes - shows all income entries
	list spendings - shows all spending entries
	list tags {$TAG} - shows entries with specific tag

Editing Entries:
	edit {$TYPE} {$INDEX} {$FIELD} {$NEW_VALUE}
	e.g., edit spending 1 amount 100
	e.g., edit income 2 description Bonus

Deleting Entries:
	delete {$TYPE} {$INDEX}
	e.g., delete spending 1

Setting Budget:
	budget {$PERIOD} {$AMOUNT}
	e.g., budget daily 50
	e.g., budget monthly 1500

Other Commands:
	help - shows this help message
	bye - exits the application
```

### Setting a Budget

The `budget` command allows you to set a daily, monthly, or yearly budget for your spendings.

**Format**: `budget {$PERIOD} {$AMOUNT}`

- `{$PERIOD}`: Specifies the period for the budget. It can be `daily`, `monthly`, or `yearly`.
- `{$AMOUNT}`: The budget amount to be set.

**Example input:**<br>
`
budget daily 50
`

**Example output**:
```
    ____________________________________________________________
    Successfully set daily budget of: 50
    ____________________________________________________________
```

### Editing an Entry

The `edit` command allows you to edit the amount, description, or date of an existing income or spending entry.

**Format:** `edit {$TYPE} {$INDEX} {$FIELD} {$NEW_VALUE}`

- `{$TYPE}`: Specifies the type of entry to be edited. It can be `spending` or `income`.
- `{$INDEX}`: The index of the entry to be edited (1-based index).
- `{$FIELD}`: The field to be edited. It can be `amount`, `description`, `tag` or `date`. Editing the frequency of a recurring entry is not allowed.
- `{$NEW_VALUE}`: The new value to be set for the specified field.
  - Note: There are restrictions for the new value in these fields:
    - amount: positive numerical value.
    - date: YYYY-MM-DD format, eg.`2023-01-21`.

**Example input:**<br>
`edit spending 1 amount 100`
`edit spending 1 description macdonalds`
`edit spending 1 tag food`
`edit spending 1 date 2024-10-10`

**Example output**:
```
    ____________________________________________________________
    Edit Successful!
    ____________________________________________________________
```

### Finding an Entry

The `find` command allows you to find entries within a range of amount or date. 
It also allows you to find entries with a specific keyword in the description.

**Format:** `find {$TYPE} {$FIELD} {$FIND_VALUE}`

- `{$TYPE}`: Specifies the type of entry to be edited. It can be `spending` or `income`.
- `{$FIELD}`: The field to be edited. It can be `amount`, `description`, or `date`.
- `{$FIND_VALUE}`: The value to find for the specified field.
- `[to $ANOTHER_FIND_VALUE]`: The upper limit of the search result.
  - Note: Range search is only available for the `amount` and `date` fields.
    - It will be seen as part of the description keyword for the `description` field
  - Note: There are restrictions for the find values in these fields:
    - amount: positive numerical value.
    - date: YYYY-MM-DD format, eg.`2023-01-21`.

**Example input:**<br>
- `find income amount 100`
- `find spending description macdonalds`
- `find spending date 2024-10-10 to 2024-12-12`

**Example output**:
```
    ____________________________________________________________
    No entries found match the criteria.
    ____________________________________________________________
```
```
    ____________________________________________________________
    Here are the matching results:
    1. macdonalds - 10 - 2024-10-10
    ____________________________________________________________
```

### Exiting the program

The `bye` command allows you to exit the program safely, as it will store all changes made.

**Format:** `bye`

**Example input:**<br>
`bye`

**Example output:**
```
	____________________________________________________________
	Bye. Hope to see you again soon!
	____________________________________________________________
```

### Saving the data 
All data previously inputted into the programme will be automatically saved upon the user exiting via the `bye` command.
There is no need to save manually.

### Editing the data file
> <span style="color:#f5220d">WARNING</span> </br>
> This section is dedicated to advanced users who are confident in updating the data file manually. Failure 
> to do so correctly can lead to data corruption and having possibly all previous information wiped out. </br>

User data is stored into 3 text files, namely
- password.txt: `[JARFILE LOCATION]/password.txt`, stores the user password
- spendings.txt: `[JARFILE LOCATION]/spendings.txt`, stores all the user spending data
- incomes.txt: `[JARFILE LOCATION]/incomes.txt`, stores all the user income data

#### Format of data storage for password:
For security purposes the method of storage will not be discussed. <span style="color:#f5220d">DO NOT</span> 
alter this file, simply delete the file if you have forgotten you password and create a new password upon being 
prompt when start up.

#### Format of data storage for income and spending:
Data are stored with `|` used as delimiter. Each line in the text file represents one entry. </br>
Format: 
`[$AMOUNT]|[$DESCRIPTION]|[$DATE_OF_ENTRY]|[TAG_NAME]|[RECURRENCE_FREQUENCY]|[LAST_RECURRENCE]|[DAY_OF_RECURRENCE]`
</br>
</br>
For spending.txt, the first line of entry stores the budgets of the user.</br>
Format: `[$DAILY_BUDGET]|[$MONTLY_BUDGET]|[$YEARLY_BUDGET]` </br>
</br>
Important data representation to note:
- `[$AMOUNT]`/`[$DAILY_BUDGET]`/`[$MONTHLY_BUDGET]`/`[$YEARLY_BUDGET]`: In 2 decimal places
- `[$DATE_OF_ENTRY]`: In the format of `YYYY-MM-DD`
- `[$RECURRENCE_FREQUENCY]`: In the format of `NONE`/`DAILY`/`MONTHLY`/`YEARLY`
- `[$DAY_OF_RECURRENCE]`: To match the day stored in `[$DATE_OF_ENTRY]`

We recommend not to edit `[$LAST_RECURRENCE]`. If manually adding new entries with recurrence, `[$LAST_RECURRENCE]`
should match `[$DATE_OF_ENTRY]`, "null" otherwise.

## FAQ

**Q**: How do I transfer my data to another computer? 

**A**: Simply transfer `incomes.txt`, `spendings.txt` and `password.txt` files to the folder that the program 
is at.

**Q**: Why are the indices of the entries not in consecutive order when I list all entries of a particular tag 
or when I list entries in a time range?

**A**: Each index reflects the actual index of the item in the entire list so that you can edit or delete the 
entry easily.

**Q**: What happens if I edit the date of a recurring entry to an earlier date?

**A**: The date of the entry will be changed, but no additional entries will be created between the new date and the 
current date.

**Q**: What happends if I add a recurring entry with an earlier date?

**A**: You will have the option to select whether you would like to add the additional entries between the date of entry and the current date.

## Command Summary
<table>
    <thead>
        <tr>
            <th colspan="2">Command</th>
            <th>Format</th>
            <th>Examples</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan="2">Adding</td>
            <td>Income</td>
            <td></td>
        </tr>
        <tr>
            <td>Spending</td>
            <td></td>
        </tr>
        <tr>
            <td rowspan="4">Listing entries</td>
            <td>All spendings</td>
            <td></td>
        </tr>
        <tr>
            <td>All incomes</td>
            <td></td>
        </tr>
        <tr>
            <td>All tags</td>
            <td></td>
        </tr>
        <tr>
            <td>All of a specific tag</td>
            <td></td>
        </tr>
        <tr>
            <td rowspan="2">Deleting entries</td>
            <td>Income</td>
            <td></td>
        </tr>
        <tr>
            <td>Spending</td>
            <td></td>
        </tr>
        <tr>
            <td rowspan="3">Setting budget</td>
            <td>Daily</td>
            <td></td>
        </tr>
        <tr>
            <td>Monthly</td>
            <td></td>
        </tr>
        <tr>
            <td>Yearly</td>
            <td></td>
        </tr>
        <tr>
            <td rowspan="2">Finding entries</td>
            <td>Income</td>
            <td>find income {$FIELD} {$FIND_VALUE} [to $ANOTHER_FIND_VALUE]</td>
            <td>find income description salary</td>
        </tr>
        <tr>
            <td>Spending</td>
            <td>find spending {$FIELD} {$FIND_VALUE} [to $ANOTHER_FIND_VALUE]</td>
            <td>find spending amount 10 to 100</td>
        </tr>
    </tbody>
</table>


[//]: # ({Give a 'cheat sheet' of commands here})
[//]: # (* Add todo `todo n/TODO_NAME d/DEADLINE`)
