package com.escod.kepler.view.activitydetail;

import com.escod.kepler.entity.activity.ActivityDetail;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.action.list.EditAction;
import io.jmix.flowui.action.list.RemoveAction;
import io.jmix.flowui.component.genericfilter.GenericFilter;
import io.jmix.flowui.view.*;

@Route(value = "activityDetails", layout = MainView.class)
@ViewController("ActivityDetail.list")
@ViewDescriptor("activity-detail-list-view.xml")
@LookupComponent("activityDetailsDataGrid")
@DialogMode(width = "64em")
public class ActivityDetailListView extends StandardListView<ActivityDetail> {
  @ViewComponent
  private GenericFilter genericFilter;

  @ViewComponent("activityDetailsDataGrid.edit")
  private EditAction<ActivityDetail> activityDetailsDataGridEdit;

  @ViewComponent
  private HorizontalLayout lookupActions;

  @ViewComponent("activityDetailsDataGrid.remove")
  private RemoveAction<ActivityDetail> activityDetailsDataGridRemove;

  @Subscribe
  public void onReady(final ReadyEvent event) {
    if (lookupActions.isVisible()) {
      activityDetailsDataGridEdit.setVisible(Boolean.FALSE);
      activityDetailsDataGridRemove.setVisible(Boolean.FALSE);
      genericFilter.setVisible(Boolean.FALSE);
    }
  }

}