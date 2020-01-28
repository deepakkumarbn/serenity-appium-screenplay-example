package com.offline.city.map.serenity.cucumber.steps;

import com.offline.city.map.serenity.tasks.Go;
import com.offline.city.map.serenity.tasks.Launch;
import com.offline.city.map.serenity.tasks.Search;

import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isIn;


public class SearchRouteSteps {

    Scenario scenario;

    @Before
    public void set_the_stage(Scenario scenario) {
//        commuterActor.can(net.serenitybdd.screenplay.abilities.BrowsingTheWeb.with(driver));
        OnStage.setTheStage(new OnlineCast());
        this.scenario = scenario;
        Serenity.setSessionVariable("ScenarioName").to(scenario.getName());

    }

    @After
    public void tearDown(){
        //Serenity.setSessionVariable("deviceType").to(null);
        //Serenity.clearCurrentSession();
        OnStage.drawTheCurtain();
    }

    @Given("^that (.*) wants to search for a point of interest, using (.*)$")
    public void navigatesToJourneyConfiguration(String commuterName, String deviceType) throws Throwable {

        Serenity.setSessionVariable("commuterName").to(commuterName);

        Serenity.setSessionVariable("deviceType").to(deviceType);

        OnStage.theActorCalled(commuterName).attemptsTo(
                                                            Launch.theApp(),
                                                            Go.toMap()
                                                        );
    }

    @Given("^s?he needs to know where (.*) is located$")
    public void needsToKnowWhereLocationIsLocated(String location) throws Throwable {
        Search.theLocation(location);
    }

    @Then("^he should be able to see (.*) on the map$")
    public void heShouldBeAbleToSeeHauptbahnhofStuttgartOnTheMap(String location) throws Throwable{
        // Write code here that turns thePrivacyPolicy phrase above into concrete actions
    }
}
