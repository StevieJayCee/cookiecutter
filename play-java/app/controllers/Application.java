package controllers;

import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public static Result twillioCustomerCall() {
        String authToken = TwillioService.generateTwillioAuthTokenForCalling();
        return ok(twillioCall.render(authToken));
    }

    public static Result twillioCustomerService() {
        String authToken = TwillioService.generateTwillioAuthTokenForReceiving();
        return ok(twillioReceive.render(authToken));
    }


    public static Result twillioXML() {
        response().setContentType("application/xml");
        return ok("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "    <Response>\n" +
                "    <Dial>\n" +
                "    <Client>CustomerService</Client>\n" +
                "    </Dial>\n" +
                "    </Response>");
    }

}
