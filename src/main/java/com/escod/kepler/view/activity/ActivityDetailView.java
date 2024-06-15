package com.escod.kepler.view.activity;

import com.escod.kepler.entity.activity.Activity;
import com.escod.kepler.entity.activity.CategoryActivity;
import com.escod.kepler.entity.activity.CategoryActivityDetail;
import com.escod.kepler.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.core.EntityStates;
import io.jmix.flowui.component.multiselectcombobox.JmixMultiSelectComboBox;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Route(value = "activities/:id", layout = MainView.class)
@ViewController("Activity.detail")
@ViewDescriptor("activity-detail-view.xml")
@EditedEntityContainer("activityDc")
public class ActivityDetailView extends StandardDetailView<Activity> {

  @Autowired
  private EntityStates entityStates;

  @Autowired
  private DataManager dataManager;

  @ViewComponent
  private JmixMultiSelectComboBox<CategoryActivity> categoryActivitiesComboBox;

  @ViewComponent
  private CollectionLoader<CategoryActivity> categoryActivitiesDl;

  @Subscribe
  public void onReady(final ReadyEvent event) {

    boolean isNewActivity = entityStates.isNew(getEditedEntity());

    if (!isNewActivity) {
      var item = getEditedEntity();

      List<CategoryActivity> associatedCategories = getAssociatedCategories(item);
      categoryActivitiesComboBox.select(associatedCategories);
    }
  }

  @Subscribe
  public void onAfterSave(final AfterSaveEvent event) {

    var activity = getEditedEntity();
    // remove old details
//    var oldDetail = getAssociatedCategories(activity);

//    if (oldDetail!= null){
//      dataManager.remove(oldDetail);
//    }
    List<CategoryActivityDetail> categoryActivityDetails = dataManager.load(CategoryActivityDetail.class)
        .query("select c from CategoryActivityDetail c where c.activity = :activity")
        .parameter("activity", activity)
        .list();

    if (!categoryActivityDetails.isEmpty()){
      dataManager.remove(categoryActivityDetails);
    }

    var categories = categoryActivitiesComboBox.getTypedValue();

    if (categories != null && !categories.isEmpty()) {

      for (CategoryActivity categoryActivity : categories) {
        CategoryActivityDetail detail = dataManager.create(CategoryActivityDetail.class);

        detail.setActivity(activity);
        detail.setCategoryActivity(categoryActivity);
        dataManager.save(detail);
      }
    }
  }

  protected List<CategoryActivity> getAssociatedCategories(Activity activity) {
    return dataManager.load(CategoryActivity.class)
        .query("select c from CategoryActivity c join c.categoryActivityDetails cc where cc.activity = :activity")
        .parameter("activity", activity)
        .list();
  }


}