package stepsdefs;

import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Attachment
{
    @io.qameta.allure.Attachment( value = "Request and Response", type = "text/plain" )
    public static String reportGeneration( RequestSpecification request, Response response )
    {
        String body;
        if( ( ( RequestSpecificationImpl ) request ).getBody() != null )
        {
            body = ( ( RequestSpecificationImpl ) request ).getBody().toString();
        }
        else
        {
            body = "{}";
        }

        String content = "URI : \n" + ( ( RequestSpecificationImpl ) request ).getURI() + "\n\n" +
                                 "Parameters : \n" + ( ( RequestSpecificationImpl ) request ).getRequestParams() + "\n\n" +
                                 "Path Parameters : \n" + ( ( RequestSpecificationImpl ) request ).getNamedPathParams() + "\n\n" +
                                 "Request Body : \n" + body + "\n\n" +
                                 "Response : \n" + response.prettyPrint();

        return content;
    }
}
