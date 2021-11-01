package com.epam.brest.model;

import static com.epam.brest.model.StatusType.*;

public class ExitState implements Status {

    @Override
    public Status handle() {
        return null;
    }

    @Override
    public StatusType getType() {
        return EXIT;
    }
}
