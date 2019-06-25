package com.home.androidopenglesdemo.render;

import android.content.Context;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class BaseRenderer implements GLSurfaceView.Renderer {

    protected Context mContext;

    public BaseRenderer(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * GlSurfaceView創建的時候回調, 可以做一些參數初始化操作
     */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) { }

    /**
     * Surface剛創建的時候, 它的大小是0, 也就是說在畫第一次圖之前它會被調用一次
     * GlSurfaceView尺寸發送變化時回調, 例如橫豎屏切換
     */
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) { }

    /**
     * 此方法頻繁回調, 我們可以在這個方法裡面進行繪製操作
     */
    @Override
    public void onDrawFrame(GL10 gl) { }

    public void onSurfaceDestroyed() { }
}
