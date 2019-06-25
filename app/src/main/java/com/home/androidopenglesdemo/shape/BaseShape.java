package com.home.androidopenglesdemo.shape;

import android.content.Context;
import android.opengl.GLES20;
import com.home.androidopenglesdemo.util.VertexArray;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class BaseShape {

    Context mContext;
    VertexArray vertexArray;
    VertexArray indexArray;
    int mProgram;
    float[] modelMatrix = new float[16];
    float[] viewMatrix = new float[16];
    float[] projectionMatrix = new float[16];
    int POSITION_COMPONENT_COUNT;

    BaseShape(Context context) {
        mContext = context;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) { }

    public void onSurfaceChanged(GL10 gl, int width, int height) { }

    public void onDrawFrame(GL10 gl) {
        GLES20.glClearColor(0f, 0f, 0f, 1f);
        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
    }

    public void onDrawFrame(GL10 gl, float[] mvpMatrix) {
        GLES20.glClearColor(0f, 0f, 0f, 1f);
        GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
    }

    public void onSurfaceDestroyed() { }
}
