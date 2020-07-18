package stepsdefs;

import cucumber.api.java8.En;
import io.restassured.response.ValidatableResponse;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class Assertions implements En
{
    ValidatableResponse validatableResponse;

    public Assertions()
    {
        Then( "^I should get a successful response with status code (\\d+)$", ( Integer statusCode ) ->
        {
            validatableResponse = Steps.response.then().statusCode( statusCode );
            Attachment.reportGeneration( Steps.requestSpecification, Steps.response );
        } );

        And( "^page number should be (\\d+)$", ( Integer pageNumber ) ->
        {
            validatableResponse.body( "page", equalTo( pageNumber ) );
        } );

        And( "^per page should be (\\d+)$", ( Integer perPage ) ->
        {
            validatableResponse.body( "per_page", equalTo( perPage ) );
        } );

        And( "^total users should be (\\d+)$", ( Integer totalUsers ) ->
        {
            validatableResponse.body( "total", equalTo( totalUsers ) );
        } );

        And( "^total pages should be (\\d+)$", ( Integer totalPages ) ->
        {
            validatableResponse.body( "total_pages", equalTo( totalPages ) );
        } );

        And( "^response should return (\\d+) users$", ( Integer usersCount ) ->
        {
            validatableResponse.body( "data", hasSize( usersCount ) );
        } );

        And( "^users should have an id$", () ->
        {
            validatableResponse.body( "data.id", everyItem( notNullValue() ) );
        } );

        And( "^user id (\\d+) first name should be \"([^\"]*)\" AND last name should be \"([^\"]*)\"$", ( Integer userId, String firstName, String lastName ) ->
        {
            ArrayList<Integer> userIds = validatableResponse.extract().path( "data.id" );
            int index = userIds.indexOf( userId );

            validatableResponse.body( "data[" + index + "].first_name", equalTo( firstName ), "data[" + index + "].last_name", equalTo( lastName ) );
//            "data[0].first_name"
        } );

        And( "^user should have an id$", () ->
        {
            validatableResponse.body( "data.id", notNullValue() );
        } );

        And( "^user first name should be \"([^\"]*)\" AND last name should be \"([^\"]*)\"$", ( String firstName, String lastName ) ->
        {
            validatableResponse.body( "data.first_name", equalTo( firstName ), "data.last_name", equalTo( lastName ) );
        } );

        And( "^new user should have an id$", () ->
        {
            validatableResponse.body( "id", notNullValue() );
        } );
        And( "^user name should be \"([^\"]*)\" AND job should be \"([^\"]*)\"$", ( String name, String job ) ->
        {
            validatableResponse.body( "name", equalTo( name ), "job", equalTo( job ) );
        } );

        And( "^created date should be \"([^\"]*)\"$", ( String createdAt ) ->
        {
            if( createdAt.equals( "today" ) )
            {
                createdAt = LocalDate.now().toString();
            }
            validatableResponse.body( "createdAt", containsString( createdAt ) );
            validatableResponse.body( "createdAt", startsWith( createdAt ) );
        } );
        And( "^updated date should be \"([^\"]*)\"$", ( String updatedAt ) ->
        {
            if( updatedAt.equals( "today" ) )
            {
                updatedAt = LocalDate.now().toString();
            }
            validatableResponse.body( "updatedAt", containsString( updatedAt ) );
            validatableResponse.body( "updatedAt", startsWith( updatedAt ) );
        } );
    }
}
