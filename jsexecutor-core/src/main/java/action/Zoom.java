package action;

import annotation.Exec;
import constants.Constants.Arguments;
import manager.BuilderManager;

public class Zoom
{
    public Zoom()
    {
        new BuilderManager(this);
    }

    @Exec(js = "document.body.style.zoom = " + Arguments.FIRST)
    public String pageZoom;
}
