package action;

import annotation.ExecBy;
import constants.Constants.Arguments;

public class Zoom
{
    public Zoom()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = "document.body.style.zoom = " + Arguments.FIRST + "")
    public String pageZoom;
}
