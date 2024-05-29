package com.escod.kepler.view.activity;

import com.escod.kepler.entity.activity.Activity;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "activities/:id", layout = MainView.class)
@ViewController("Activity.detail")
@ViewDescriptor("activity-detail-view.xml")
@EditedEntityContainer("activityDc")
public class ActivityDetailView extends StandardDetailView<Activity> {
}