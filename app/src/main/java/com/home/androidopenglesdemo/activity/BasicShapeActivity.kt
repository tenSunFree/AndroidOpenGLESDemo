package com.home.androidopenglesdemo.activity

import com.home.androidopenglesdemo.shape.Cube

class BasicShapeActivity : BaseRenderActivity() {

    override fun setInitShape() {
        super.setInitShape()
        renderer.setShape(Cube::class.java)
    }
}
