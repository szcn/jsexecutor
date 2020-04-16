package action;

import annotation.ExecBy;

public class Zoom
{
    public Zoom()
    {
        new JSFieldManager(this);
    }

    @ExecBy(js = "document.body.style.zoom = " + JSConstants.Objects.FIRST + "")
    public String pageZoom;
}
