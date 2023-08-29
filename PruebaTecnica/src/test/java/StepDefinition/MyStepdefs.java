package StepDefinition;

import Pages.*;
import Utilities.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;


public class MyStepdefs extends BaseClass {

    Home home = new Home();
    Trip trip;
    Seats seats;
    Bags bags;
    Extras extras;

    Payment payment;

    @Given("^Open the Firefox and launch the application$")
    public void openTheFirefoxAndLaunchTheApplication() throws InterruptedException {
        Home home = new Home();
        home.inicio();

    }



    @When("Enter {string} {string}  and {string} {string}")
    public void enterAnd(String departureCountry, String departureCity, String destinationCountry, String destinationCity){
        home.enterDeparture(departureCountry, departureCity);
        home.enterDestination(destinationCountry, destinationCity);
    }

    @And("Enter departureDate")
    public void enterDepartureDate() {
        home.selectDepartureDate();
    }

    @And("Enter comeBackDate")
    public void enterComeBackDate() {
        home.selectComeBackDate();
    }

    @And("Add {int} adults and {int} child")
    public void addAnAdult(int numAdults, int numChilden) {
        home.addAdult(numAdults);
        home.addChild(numChilden);
    }

    @And("Click on Search button")
    public void clickOnSearchButton() {

        home.clickSearchButton();
    }

    @And("Select FirstFlight")
    public void selectFirstFlight() {
        trip = new Trip();
        trip.selectDepartureFlight();
    }

    @And("Select SecondFlight")
    public void selectSecondFlight() {
        trip.selectComeBackFlight();
    }


    @And("Select new departure date {string}")
    public void selectNewDepartureDate(String date) {
        home.selectDate(date);
    }


    @And("Select new comeback date {string}")
    public void selectNewComebackDate(String date) {
        home.selectDate(date);
    }

    @And("Select {string} fare")
    public void selectRegularFare(String fare) {
        trip.selectFare(fare);
    }

    @And("Select month {string}")
    public void selectMonth(String month) {
        home.selectMonth(month);
    }

    @And("Open departureDate")
    public void openDepartureDate() {
        home.openDepartureCalendar();
    }

    @And("Click on Log in later")
    public void clickOnLogInLater() {
        trip.clickLogInLater();
    }

    @And("Fill {string} {string} {string}")
    public void fill(String title, String firstName, String lastName) {
        trip.fillAdultPassengerDetails(title, firstName, lastName);
    }

    @And("Fill child {string} {string}")
    public void fillChild(String firstName, String lastName) {
        trip.fillChilPassengerDetails(firstName, lastName);
    }

    @And("Click on Continue button")
    public void clickOnContinueButton() {
        trip.clickContinue();
    }

    @And("Click OKay modal")
    public void clickOKayModal() {
        seats = new Seats();
        seats.clickOKModal();
    }

    @And("Select {int} seats")
    public void selectSeats(int numSeats) {
        seats.selectSeats(numSeats);
    }

    @And("Click on Next Flight")
    public void clickOnNextFlight() {
        seats.clickNextFlight();
    }

    @And("Do not Add Fast Track")
    public void doNotAddFastTrack() {
        seats.doNotAddFastTrack();
    }

    @And("Select small bag")
    public void selectSmallBag() {
        bags = new Bags();
        bags.checkSmallBag();
    }

    @And("Click on Continue button Seats Page")
    public void clickOnContinueButtonSeatsPage() {
        seats.continueButton();
    }

    @And("Click on Continue button Bags Page")
    public void clickOnContinueButtonBagsPage() {
        bags.continueButton();
    }

    @And("Click on Continue button Extras Page")
    public void clickOnContinueButtonExtrasPage() {
        extras = new Extras();
        extras.continueButton();
    }

    @And("Click on Continue button Extras TransportPage")
    public void clickOnContinueButtonExtrasTransportPage() {
        extras.continueButtonTransport();
    }

    @Then("Payment page is reached")
    public void paymentPageIsReached() {
        payment = new Payment();
        Assert.assertTrue(payment.getURL().contains("payment"));
    }

}
