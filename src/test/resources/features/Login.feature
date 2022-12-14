Feature: Login and E2E Test
  @wip
  Scenario:Login and End to End Test
    Given The user is on the login page
    When The user is enters "standard_user" and "secret_sauce"
    Then The user should be able to login and see "PRODUCTS" header
    #1 methodları al,loginstep oluştur,
#  And The user should be able to sort products high to low
  And The user should be able to sort products "Price (high to low)"
#  And The user clicks cheapest and second costliest product
  And The user clicks cheapest as "7.99" and second costliest as "29.99" product
#yukarıdaki step için tek parametreli methodu her parametre için kullanacağız
#15.99 ve 49.99 ile çalıştır
  And The user open basket
  And The user clicks checkout
  #çalıştır
  And The user enters details "Jhon" "Snow" "BB13DD" and finish the purchase
   # Then The user verify that total is "Total: $41.02"
  Then The user verify that items are "41.02" and able to total is "Total: $41.02"

