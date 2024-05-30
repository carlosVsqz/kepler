package com.escod.kepler.view.categoryactivity;

import com.escod.kepler.entity.activity.CategoryActivity;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "categoryActivities", layout = MainView.class)
@ViewController("CategoryActivity.list")
@ViewDescriptor("category-activity-list-view.xml")
@LookupComponent("categoryActivitiesDataGrid")
@DialogMode(width = "64em")
public class CategoryActivityListView extends StandardListView<CategoryActivity> {
}