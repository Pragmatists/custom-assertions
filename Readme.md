Example of Custom assertions from assertJ library

https://assertj.github.io/doc/#assertj-core-custom-assertions


* create new test that will use custom assertions
* write the code you would like to have in assertions
* create class from test code
* extend AbstractAssert<self, actual>
* generate a constructor matching super
* create assetThat method from test class
* add first assertion isOpen
* add isNotNull to check actual is not null
* add state assertions and see how the test fails
* add another assertion
* Providing an entry point for all custom assertions
 - move method to a new class
 - extend AssertJAssertions


