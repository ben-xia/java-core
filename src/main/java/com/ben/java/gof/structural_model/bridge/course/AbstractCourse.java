package com.ben.java.gof.structural_model.bridge.course;

import java.util.StringJoiner;

/**
 * @author: ben.xia
 * @desc: 桥梁[看类图]
 * @date: 2023/6/11
 */
public class AbstractCourse implements ICourse{
    private INote note;
    private IVideo video;

    public void setNote(INote note) {
        this.note = note;
    }

    public void setVideo(IVideo video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AbstractCourse.class.getSimpleName() + "[", "]")
                .add("note=" + note)
                .add("video=" + video)
                .toString();
    }
}
