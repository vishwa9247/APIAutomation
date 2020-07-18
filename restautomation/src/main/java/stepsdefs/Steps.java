package stepsdefs;

import cucumber.api.java8.En;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Steps implements En
{
    static RequestSpecification requestSpecification;
    static Response response;

    public Steps()
    {
        Given( "^I want to search for all users$", () ->
        {
            requestSpecification = given();
        } );

        When( "^I click search all users$", () ->
        {
            response = requestSpecification.when().get( "https://reqres.in/api/users" );
            response.prettyPrint();
        } );

        Given( "^I want to search for users in page (\\d+)$", ( Integer pageNo ) ->
        {
            requestSpecification = given().param( "page", pageNo );
        } );

        When( "^I click search users in the page$", () ->
        {
            response = requestSpecification.when().get( "https://reqres.in/api/users" );
            response.prettyPrint();

            System.out.println( ( ( RequestSpecificationImpl ) requestSpecification ).getURI() );
        } );

        Given( "^I want to search for user id (\\d+)$", ( Integer userId ) ->
        {
            requestSpecification = given().pathParam( "id", userId );
        } );

        When( "^I click search user$", () ->
        {
            response = requestSpecification.when().get( "https://reqres.in/api/users/{id}" );
            response.prettyPrint();
            System.out.println( ( ( RequestSpecificationImpl ) requestSpecification ).getURI() );
        } );

        Given( "^I want to create a user with name \"([^\"]*)\" AND job \"([^\"]*)\"$", ( String name, String job ) ->
        {
            JsonObject request = new JsonObject();
            request.addProperty( "name", name );
            request.addProperty( "job", job );

            requestSpecification = given().contentType( "application/json" ).body( request.toString() );
        } );

        When( "^I click create user$", () ->
        {
            response = requestSpecification.when().post( "https://reqres.in/api/users" );
            System.out.println( ( ( RequestSpecificationImpl ) requestSpecification ).getBody() );
            System.out.println( ( ( RequestSpecificationImpl ) requestSpecification ).getURI() );
            response.prettyPrint();
        } );

        Given( "^I want to update user id (\\d+) name as \"([^\"]*)\" AND job as \"([^\"]*)\"$", ( Integer userId, String name, String job ) ->
        {
            JsonObject request = new JsonObject();
            request.addProperty( "name", name );
            request.addProperty( "job", job );

            requestSpecification = given().contentType( "application/json" ).body( request.toString() ).pathParam( "id", userId );
        } );

        When( "^I click update user$", () ->
        {
            response = requestSpecification.when().put( "https://reqres.in/api/users/{id}" );
            System.out.println( ( ( RequestSpecificationImpl ) requestSpecification ).getBody() );
            System.out.println( ( ( RequestSpecificationImpl ) requestSpecification ).getURI() );
            response.prettyPrint();
        } );

        Given( "^I want to delete user id (\\d+)$", ( Integer id ) ->
        {
            requestSpecification = given().pathParam( "id", id );
        } );

        When( "^I click delete user$", () ->
        {
            response = requestSpecification.when().delete( "https://reqres.in/api/users/{id}" );
            System.out.println( ( ( RequestSpecificationImpl ) requestSpecification ).getURI() );
            response.prettyPrint();
        } );
    }
}
