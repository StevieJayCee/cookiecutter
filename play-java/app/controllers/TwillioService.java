package controllers;

import com.twilio.sdk.client.TwilioCapability;

/**
 * Created by gsayers on 14/02/15.
 */
public class TwillioService {

    /**
     * Generates an API token that can be used to instantiate a VOIP call by the browser.
     * @return Twillio auth token.
     */
    public static String generateTwillioAuthTokenForCalling() {

        TwilioCapability capability = new TwilioCapability("AC9636fa658d8e3b020fcd78a23c846e7c", "a2f3f8f09604c1c517484f02a27e09d5");

        String applicationSid = "AP4eeb352c0e1612095e9045234cfca234";
        capability.allowClientOutgoing(applicationSid);

        String apiToken = null;
        try {
            apiToken = capability.generateToken();
        } catch (TwilioCapability.DomainException e) {
            e.printStackTrace();
        }

        return apiToken;
    }

    /**
     * Generates an API token that can be used to instantiate a VOIP call by the browser.
     * @return Twillio auth token.
     */
    public static String generateTwillioAuthTokenForReceiving() {

        TwilioCapability capability = new TwilioCapability("AC9636fa658d8e3b020fcd78a23c846e7c", "a2f3f8f09604c1c517484f02a27e09d5");

        // Find an application Sid from twilio.com/user/account/apps
        String applicationSid = "AP7ef04bf7577be48981128c1f115d3448";
        capability.allowClientIncoming("CustomerService");

        String apiToken = null;
        try {
            apiToken = capability.generateToken();
        } catch (TwilioCapability.DomainException e) {
            e.printStackTrace();
        }

        return apiToken;
    }
}
