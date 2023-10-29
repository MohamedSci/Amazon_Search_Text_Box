# Amazon_Search_Text_Box

A Maven Java Project that Creates an automated a set of test cases to perform black box, end-to-end testing for Amazon search text box.

Techs:
- Java
- OOP
- Maven
- Selenium
- DDT
- BDD
- Cucumber

It automates a scenario of searching a product from search text box then go to products page and tap a favourite product to go to this product details page then add this product to the checklist cart. this BDD scenario is automated with Selenium , Testng and cucumber there is feature file that has the scenario written in Gherkin Language and Steps file that has the corresponding tests for the feature file and Runner file that is connect the feature to Steps.
There Page object model is used in this project which means each Web page has a corresponding Java class all needed elements are instintiated there.

There are some automated test cases to test the capabilities of Search box. 
TC1: When the User tap the Search Box it will be active and the outlines will be orange and a drop down list with auto random suggested items is displayed.
TC3: When the User input a word in the Search Box then click the Search icon button next to the search box, a new page is displayed and the title of the first item from the list contains the clicked inputed word.
TC4: When the User input a word in the Search Box then click enter from keyboard, a new page is displayed and the title of the first item from the list contains the clicked inputed word.
TC4: When the User click on an item from the suggestions, a new page is displayed and the title of the first item from the list contains the clicked item's name.
TC5: When the User input a character for example "a", a drop down list with random suggested items begins with letter "a" will be displayed.
TC6: When the user used the drop down button beside the search box to filter and validate the suggestions of items retrived from search box the suggested items will be according the selected category.

The pom.xml file has all used dependiencies.
The testng.xml file has all classes used in the scenario.
There is a useful function that takes screenshots of failed tests.
