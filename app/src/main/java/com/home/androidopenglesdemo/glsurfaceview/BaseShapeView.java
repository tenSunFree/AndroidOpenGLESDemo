package com.home.androidopenglesdemo.glsurfaceview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import com.home.androidopenglesdemo.render.BaseRenderer;

@SuppressLint("ViewConstructor")
public class BaseShapeView extends GLSurfaceView {

    private BaseRenderer baseRenderer;

    public BaseShapeView(Context context, BaseRenderer renderer) {
        super(context);
        setEGLContextClientVersion(2);
        baseRenderer = renderer;
        setRenderer(baseRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    /**
     * GlSurfaceView創建的時候回調, 可以做一些參數初始化操作
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        super.surfaceCreated(holder);
    }

    /**
     * GlSurfaceView尺寸發送變化時回調, 例如橫豎屏切換
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        super.surfaceChanged(holder, format, w, h);
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        super.surfaceDestroyed(holder);
        baseRenderer.onSurfaceDestroyed();
    }
}
