import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

class PostmanEchoTest {

  @Test
      void PostRequest() {

          given()
            .baseUri("https://postman-echo.com")
            .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)

            .when()
            .post("/post")

            .then()
            .statusCode(200)
            .body("data", equalTo("some data"))
    ;
  }

   @Test
   void shouldTestSomeData() {
       given()
               .baseUri("https://postman-echo.com")
               .contentType("text/plain; charset=UTF-8")
               .body("Good Day")

               .when()
               .post("/post")

               .then()
               .statusCode(200)
               .body("data", equalTo("Good Day"))
       ;
   }

    @Test
    void shouldRequestBasicAuth() {
        given()
                .baseUri("https://postman-echo.com")
                .headers("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==")

                .when()
                .get("/basic-auth")

                .then()
                .statusCode(200)
                .body("authenticated", equalTo(true))
        ;
    }
}
