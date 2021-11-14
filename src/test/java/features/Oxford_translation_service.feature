Feature: Validation of responses for Oxford's Public APIs for Translation
  FirstCase is to test for status code 404 (French as target lang) with source language as en and target language as fr
  SecondCase is to test for status code 200 with source language as en and target language as ar
  ThirdCase is to test for status code 400 (junk query params key) with source language as en and target language as ar

  Scenario Outline: API test to verify the 404 response for the translation of a word 'Test'
    Given I make a GET request with source language as "<source_lang_translate>" and target language as "<target_lang_translate>" and word as "<word_id>" and "<strictMatch>" and "<fields>"
    And I check status code is "404"
    Examples:
      | source_lang_translate | target_lang_translate| word_id   | fields       |strictMatch|
      | en                    | fr                   | Test      | translations |true       |


  Scenario Outline: API test to verify the 200 response for the translation of a word 'ace'
    Given I make a GET request with source language as "<source_lang_translate>" and target language as "<target_lang_translate>" and word as "<word_id>" and "<strictMatch>" and "<fields>"
    And I check status code is "200"
    Examples:
      | source_lang_translate | target_lang_translate| word_id   |strictMatch|fields      |
      | en                    | ar                   | ace       |false      |translations|

  Scenario Outline: API test to verify the 400 response for the translation of a word 'ace'
    Given I make GET request with source language as "<source_lang_translate>" and target language as "<target_lang_translate>" and word as "<word_id>" and "<strictMatch>" and "<fields>"
    And I check status code is "400"
    Examples:
      | source_lang_translate | target_lang_translate| word_id   | fields      |strictMatch|
      | en                    | ar                   | ace       |translations |true       |

