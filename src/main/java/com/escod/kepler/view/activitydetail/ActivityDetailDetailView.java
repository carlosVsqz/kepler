package com.escod.kepler.view.activitydetail;

import com.escod.kepler.entity.activity.ActivityDetail;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.EditedEntityContainer;
import io.jmix.flowui.view.StandardDetailView;
import io.jmix.flowui.view.ViewController;
import io.jmix.flowui.view.ViewDescriptor;

@Route(value = "activityDetails/:id", layout = MainView.class)
@ViewController("ActivityDetail.detail")
@ViewDescriptor("activity-detail-detail-view.xml")
@EditedEntityContainer("activityDetailDc")
public class ActivityDetailDetailView extends StandardDetailView<ActivityDetail> {

}