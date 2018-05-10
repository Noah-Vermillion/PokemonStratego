/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokemon;

/**
 *
 * @author 373000888
 */
public class Window
{
    static final int XBORDER = 20;
    static final int YBORDER = 20;
    static final int YTITLE = 30;
    static final int WINDOW_BORDER = 8;
    static final int WINDOW_WIDTH = 2*(WINDOW_BORDER + XBORDER) + 1050;
    static final int WINDOW_HEIGHT = YTITLE + WINDOW_BORDER + 2 * YBORDER + 800;
    
    static int xsize = -1;
    static int ysize = -1;
    
    public static int getX(int x) {
        return (x + Window.XBORDER + Window.WINDOW_BORDER);
    }

    public static int getY(int y) {
        return (y + Window.YBORDER + Window.YTITLE );
    }

    public static int getYNormal(int y) {
        return (-y + Window.YBORDER + Window.YTITLE + getHeight2());
    }
    
    public static int getWidth2() {
        return (Window.xsize - 2 * (Window.XBORDER + Window.WINDOW_BORDER));
    }

    public static int getHeight2() {
        return (Window.ysize - 2 * Window.YBORDER - Window.WINDOW_BORDER - Window.YTITLE);
    }    
}