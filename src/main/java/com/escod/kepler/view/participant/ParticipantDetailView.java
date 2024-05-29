package com.escod.kepler.view.participant;

import com.escod.kepler.entity.activity.Participant;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "participants/:id", layout = MainView.class)
@ViewController("Participant.detail")
@ViewDescriptor("participant-detail-view.xml")
@EditedEntityContainer("participantDc")
public class ParticipantDetailView extends StandardDetailView<Participant> {
}