package com.home.androidopenglesdemo.util;

import android.content.Context;
import timber.log.Timber;

import static android.opengl.GLES20.*;

/**
 * 创建一个 OpenGL 程序的通用步骤
 */
public class ShaderHelper {

    private static final String TAG = "ShaderHelper";

    /**
     * 编译顶点着色器
     */
    private static int compileVertexShader(String shaderCode) {
        return compileShader(GL_VERTEX_SHADER, shaderCode);
    }

    /**
     * 编译片段着色器
     */
    private static int compleFragmentShader(String shaderCode) {
        return compileShader(GL_FRAGMENT_SHADER, shaderCode);
    }

    /**
     * 根据类型编译着色器
     */
    private static int compileShader(int type, String shaderCode) {
        final int shaderObjectId = glCreateShader(type);
        if (shaderObjectId == 0) {
            Timber.d("could not create new shader");
            return 0;
        }
        glShaderSource(shaderObjectId, shaderCode);
        glCompileShader(shaderObjectId);
        final int[] compileStatsu = new int[1];
        glGetShaderiv(shaderObjectId, GL_COMPILE_STATUS, compileStatsu, 0);
        if ((compileStatsu[0] == 0)) {
            glDeleteShader(shaderObjectId);
            Timber.d("Compilation of shader failed");
            return 0;
        }
        return shaderObjectId;
    }

    private static int linkProgram(int vertexShaderId, int fragmentShaderId) {
        final int programObjectId = glCreateProgram();
        if (programObjectId == 0) {
            Timber.d("Could not create new program");
            return 0;
        }
        glAttachShader(programObjectId, vertexShaderId);
        glAttachShader(programObjectId, fragmentShaderId);
        glLinkProgram(programObjectId);
        final int[] linkStatus = new int[1];
        glGetProgramiv(programObjectId, GL_LINK_STATUS, linkStatus, 0);
        Timber.d("Result of linking program:\n" + glGetProgramInfoLog(programObjectId));
        if (linkStatus[0] == 0) {
            glDeleteProgram(programObjectId);
            Timber.d("Linking of program failed");
            return 0;
        }
        return programObjectId;
    }

    private static void validateProgram(int programObjectId) {
        glValidateProgram(programObjectId);
        final int[] validateStatus = new int[1];
        glGetProgramiv(programObjectId, GL_VALIDATE_STATUS, validateStatus, 0);
        Timber.d("Result of validating program: " + validateStatus[0] + "\nLog:" + glGetProgramInfoLog(programObjectId));
    }

    private static int buildProgram(String vertexShaderSource, String fragmentShaderSource) {
        int program;
        LogUtil.d("vertex is " + vertexShaderSource + " frag is " + fragmentShaderSource);
        int vertexShader = compileVertexShader(vertexShaderSource);
        int fragmentShader = compleFragmentShader(fragmentShaderSource);
        program = linkProgram(vertexShader, fragmentShader);
        validateProgram(program);
        return program;
    }

    public static int buildProgram(Context context, int vertexShaderSource, int fragmentShaderSource) {
        String vertexString = TextResourceReader.readTextFileFromResource(context, vertexShaderSource);
        String textureString = TextResourceReader.readTextFileFromResource(context, fragmentShaderSource);
        return buildProgram(vertexString, textureString);
    }
}
