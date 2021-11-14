Feature: Validation of responses for Oxford's Public APIs that returns origin of the word
  FirstCase is to test for status code 200 with source language as en-gb,word is insurance,fields is etymologies.
  SecondCase is to test for status code 400 (incorrect query param value) with source language as en-gb,word is insurance,fields is etymology.
  ThirdCase is to test for status code 404 (incorrect path parameter) with source language as engb, word is insurance,fields is etymologies.

  Scenario Outline: API test to verify 200 response that returns origin of the word
    Given I make a GET request with source language as "<source_lang>" and word as "<word_id>" and "<fields>" and "<strictMatch>"
    And I check status code is "200"
    Examples:
      | source_lang | word_id | fields      |strictMatch|
      | en-gb       |insurance| etymologies |false      |

  Scenario Outline: API test to verify 400 response that returns origin of the word
    Given I make a GET request with source language as "<source_lang>" and word as "<word_id>" and "<fields>" and "<strictMatch>"
    And I check status code is "400"
    Examples:
      | source_lang | word_id | fields      |strictMatch|
      | en-gb       |insurance| etymology   |false      |

  Scenario Outline: API test to verify 404 response that returns origin of the word
    Given I make a GET request with source language as "<source_lang>" and word as "<word_id>" and "<fields>" and "<strictMatch>"
    And I check status code is "404"
    Examples:
      | source_lang | word_id | fields      |strictMatch|
      | engb        |insurance| etymologies |false      |

