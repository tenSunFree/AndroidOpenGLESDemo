package com.home.androidopenglesdemo.activity

import android.opengl.GLSurfaceView
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.home.androidopenglesdemo.glsurfaceview.BaseShapeView
import com.home.androidopenglesdemo.render.BasicShapeRender

abstract class BaseRenderActivity : AppCompatActivity() {

    private lateinit var gLSurfaceView: BaseShapeView // GLSurfaceView
    lateinit var renderer: BasicShapeRender // Renderer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        renderer = BasicShapeRender(this)
        gLSurfaceView = BaseShapeView(this, renderer)
        gLSurfaceView.renderMode = GLSurfaceView.RENDERMODE_CONTINUOUSLY
        setInitShape()
        setContentView(gLSurfaceView)
    }

    open fun setInitShape() {}

    override fun onResume() {
        super.onResume()
        gLSurfaceView.onResume()
    }

    override fun onPause() {
        super.onPause()
        gLSurfaceView.onPause()
    }
}