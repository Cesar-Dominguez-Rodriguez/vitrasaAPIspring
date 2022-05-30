package com.ceca.alexa.servlet;

import com.amazon.ask.Skill;
import com.amazon.ask.Skills;


import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.LaunchRequestHandler;
import com.amazon.ask.dispatcher.request.handler.impl.SessionEndedRequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.SessionEndedRequest;
import com.amazon.ask.servlet.SkillServlet;
import com.ceca.alexa.handlers.CancelandStopIntentHandler;
import com.ceca.alexa.handlers.HelloWorldIntentHandler;
import com.ceca.alexa.handlers.HelpIntentHandler;

import java.util.Optional;

public class AlexaServlet extends SkillServlet {
    public AlexaServlet() {
        super(getSkill());
    }

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelloWorldIntentHandler(),
                        new HelpIntentHandler()
                )
                .withSkillId("").build();

    }
}
