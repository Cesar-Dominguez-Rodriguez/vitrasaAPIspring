package com.ceca.alexa.handlers;

import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.request.handler.GenericRequestHandler;

public class CancelandStopIntentHandler extends SkillStreamHandler implements GenericRequestHandler {
    @Override
    public boolean canHandle(Object o) {
        return false;
    }

    @Override
    public Object handle(Object o) {
        return null;
    }
}
