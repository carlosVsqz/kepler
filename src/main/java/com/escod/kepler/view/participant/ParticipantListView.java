package com.escod.kepler.view.participant;

import com.escod.kepler.entity.activity.Participant;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "participants", layout = MainView.class)
@ViewController("Participant.list")
@ViewDescriptor("participant-list-view.xml")
@LookupComponent("participantsDataGrid")
@DialogMode(width = "64em")
public class ParticipantListView extends StandardListView<Participant> {
}