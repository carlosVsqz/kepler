package com.escod.kepler.view.badge;

import com.escod.kepler.entity.activity.Badge;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "badges", layout = MainView.class)
@ViewController("Badge.list")
@ViewDescriptor("badge-list-view.xml")
@LookupComponent("badgesDataGrid")
@DialogMode(width = "64em")
public class BadgeListView extends StandardListView<Badge> {
}