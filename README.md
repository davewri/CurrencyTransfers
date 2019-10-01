# CurrencyTransfers
Selenium tests - currency transfers using transferwise (https://transferwise.com/currency-convertor/)

Test iterates over 5 sets of sample data

Example iteration:

    The test inputs from a currency to a currency

    Verifies the results 

Tests are run in Chrome

# Example Results
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running TestSuite

Starting ChromeDriver 76.0.3809.126 (d80a294506b4c9d18015e755cee48f953ddc3f2f-refs/branch-heads/3809@{#1024}) on port 2879

Only local connections are allowed.

Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.

2019-10-01 14:35:19 INFO  TestCurrency:81 - Expected Currency From: GBP - Expected Currency To: INR

2019-10-01 14:35:19 INFO  TestCurrency:82 - Actual Currency From: GBP - Actual Currency To: INR

2019-10-01 14:35:19 INFO  TestCurrency:93 - Expected amount to convert: 1000.0 - Expected amount converted: 86929.5

2019-10-01 14:35:19 INFO  TestCurrency:94 - Actual amount to convert: 1000.0 - Actual anount converted: 86929.5

--------------------------------------
2019-10-01 14:35:22 INFO  TestCurrency:81 - Expected Currency From: GBP - Expected Currency To: USD

2019-10-01 14:35:22 INFO  TestCurrency:82 - Actual Currency From: GBP - Actual Currency To: USD

2019-10-01 14:35:22 INFO  TestCurrency:93 - Expected amount to convert: 2000.0 - Expected amount converted: 2443.4

2019-10-01 14:35:22 INFO  TestCurrency:94 - Actual amount to convert: 2000.0 - Actual anount converted: 2443.4

--------------------------------------
2019-10-01 14:35:24 INFO  TestCurrency:81 - Expected Currency From: EUR - Expected Currency To: USD

2019-10-01 14:35:24 INFO  TestCurrency:82 - Actual Currency From: EUR - Actual Currency To: USD

2019-10-01 14:35:24 INFO  TestCurrency:93 - Expected amount to convert: 3000.0 - Expected amount converted: 3268.4999999999995

2019-10-01 14:35:24 INFO  TestCurrency:94 - Actual amount to convert: 3000.0 - Actual anount converted: 3268.4999999999995

--------------------------------------
2019-10-01 14:35:26 INFO  TestCurrency:81 - Expected Currency From: CAD - Expected Currency To: AUD

2019-10-01 14:35:26 INFO  TestCurrency:82 - Actual Currency From: CAD - Actual Currency To: AUD

2019-10-01 14:35:26 INFO  TestCurrency:93 - Expected amount to convert: 4000.0 - Expected amount converted: 4506.68

2019-10-01 14:35:26 INFO  TestCurrency:94 - Actual amount to convert: 4000.0 - Actual anount converted: 4506.68

--------------------------------------
2019-10-01 14:35:28 INFO  TestCurrency:81 - Expected Currency From: CHF - Expected Currency To: NOK

2019-10-01 14:35:28 INFO  TestCurrency:82 - Actual Currency From: CHF - Actual Currency To: NOK

2019-10-01 14:35:28 INFO  TestCurrency:93 - Expected amount to convert: 5000.0 - Expected amount converted: 45708.9

2019-10-01 14:35:28 INFO  TestCurrency:94 - Actual amount to convert: 5000.0 - Actual anount converted: 45708.9

--------------------------------------
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 21.217 sec - in TestSuite
