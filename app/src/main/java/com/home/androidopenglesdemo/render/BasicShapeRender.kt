package com.home.androidopenglesdemo.render

import android.content.Context
import com.home.androidopenglesdemo.shape.BaseShape
import com.home.androidopenglesdemo.shape.Point
import timber.log.Timber
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

class BasicShapeRender(context: Context) : BaseRenderer(context) {

    lateinit var shape: BaseShape

    var clazz: Class<out BaseShape> = Point::class.java

    fun setShape(shape: Class<out BaseShape>) {
        this.clazz = shape
    }

    /**
     * GlSurfaceView創建的時候回調, 可以做一些參數初始化操作
     */
    override fun onSurfaceCreated(gl: GL10?, config: EGLConfig?) {
        super.onSurfaceCreated(gl, config)
        try {
            val constructor = clazz.getDeclaredConstructor(Context::class.java)
            constructor.isAccessible = true
            shape = constructor.newInstance(mContext) as BaseShape
        } catch (e: Exception) {
            shape = Point(mContext)
            Timber.e(e)
        }
        shape.onSurfaceCreated(gl,config )
    }

    /**
     * Surface剛創建的時候, 它的大小是0, 也就是說在畫第一次圖之前它會被調用一次
     * GlSurfaceView尺寸發送變化時回調, 例如橫豎屏切換
     */
    override fun onSurfaceChanged(gl: GL10?, width: Int, height: Int) {
        shape.onSurfaceChanged(gl,width,height)
    }

    /**
     * 此方法頻繁回調, 我們可以在這個方法裡面進行繪製操作
     */
    override fun onDrawFrame(gl: GL10?) {
        shape.onDrawFrame(gl)
    }

    override fun onSurfaceDestroyed() {
        shape.onSurfaceDestroyed()
    }
}