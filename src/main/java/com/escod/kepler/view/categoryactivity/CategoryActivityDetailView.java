package com.escod.kepler.view.categoryactivity;

import com.escod.kepler.entity.activity.CategoryActivity;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "categoryActivities/:id", layout = MainView.class)
@ViewController("CategoryActivity.detail")
@ViewDescriptor("category-activity-detail-view.xml")
@EditedEntityContainer("categoryActivityDc")
public class CategoryActivityDetailView extends StandardDetailView<CategoryActivity> {
}