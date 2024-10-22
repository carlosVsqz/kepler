package com.escod.kepler.view.blog.post.posttag;

import com.escod.kepler.entity.blog.PostTag;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "postTags", layout = MainView.class)
@ViewController("PostTag.list")
@ViewDescriptor("post-tag-list-view.xml")
@LookupComponent("postTagsDataGrid")
@DialogMode(width = "64em")
public class PostTagListView extends StandardListView<PostTag> {
}