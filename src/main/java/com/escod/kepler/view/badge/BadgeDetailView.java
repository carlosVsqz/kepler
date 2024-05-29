package com.escod.kepler.view.badge;

import com.escod.kepler.entity.activity.Badge;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "badges/:id", layout = MainView.class)
@ViewController("Badge.detail")
@ViewDescriptor("badge-detail-view.xml")
@EditedEntityContainer("badgeDc")
public class BadgeDetailView extends StandardDetailView<Badge> {
}