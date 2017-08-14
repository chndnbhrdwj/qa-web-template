Feature: Sample

  @ui @pageobject
  Scenario: Should be able to search for a product from the input box
    Given John is viewing the Etsy landing page
    When he searches for a product from the input box
    Then the result should be displayed

  @ui @screenplay
  Scenario: Should be able to search for a product from the input box (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)

  @ui @screenplay
  Scenario: Should be able to see sort by section (screenplay)
    Given John is viewing the Etsy landing page (screenplay)
    When he searches for a product from the input box (screenplay)
    Then the result should be displayed (screenplay)
    And he should see the sorting option

  @ui @screenplay
  Scenario Outline: Should be able to search for a product from the drop-down menu
    Given Peter is viewing the Etsy landing page (screenplay)
    When he selects <SubMenuOption> under navigation menu <MenuOption>
    Then the result should be displayed for selected option

    Examples:
      | MenuOption    | SubMenuOption |
      | Jewellery     | Anklets       |
      | Entertainment | Poetry        |
      | Weddings      | Hats          |


  @ui @screenplay
  Scenario Outline: Should be able to search for a product from the icons
    Given Peter is viewing the Etsy landing page (screenplay)
    When he selects <Icon> icon
    Then the result should be displayed for selected option

    Examples:
      | Icon      |
      | Clothing  |
      | Jewellery |
      | Weddings  |

  @api
  Scenario Outline: Should return search api results
    Given Peter want to call api to search for <Search Text>
    When he make the search api call
    Then he should see the results in response

    Examples:
      | Search Text |
      | Baby        |
      | Blanket     |
      | Bike        |

    @api
    Scenario: Should see the navigation categories in api response
      Given Peter want to call api for navigation categories
      When he make the categories api call
      Then he should see the categories in response
