package com.escod.kepler.view.blog.post.posttag;

import com.escod.kepler.entity.blog.PostTag;

import com.escod.kepler.view.main.MainView;

import com.vaadin.flow.router.Route;
import io.jmix.flowui.view.*;

@Route(value = "tag/:id", layout = MainView.class)
@ViewController("PostTag.detail")
@ViewDescriptor("post-tag-detail-view.xml")
@EditedEntityContainer("postTagDc")
public class PostTagDetailView extends StandardDetailView<PostTag> {
}