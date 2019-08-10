package com.hunter.helloandroid.module.custom.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.io.Serializable;
import java.text.ParseException;

/**
 * ================================================================
 * <p>
 * 版    权： HunterHuang(c)2018
 * <p>
 * 作    者： Hunter_1125607007@QQ.COM
 * <p>
 * 版    本： V1.0
 * <p>
 * 创建日期： 2018/5/31 18:02
 * <p>
 * 描    述：
 * <p>
 * <p>
 * 修订历史：
 * <p>
 * ================================================================
 */
public class PathStringView extends View implements Serializable {

    public PathStringView(Context context) {
        super(context);
        init();
    }

    public PathStringView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PathStringView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint mPaint;
    private Path mPath;

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.GRAY);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);

        SvgPathParser svgPathParser = new SvgPathParser();
        String pathStr = "M1102,231c-0.333,4-0.667,8-1,12c-5.485,3.587-7.93,10.365-13,14\n" +
                "\tc-2.614,1.875-6.53,2.04-9,4c4.002,2.434,5.968,4.313,6,11c-0.804,1.021-0.355,0.274-1,2c-0.667,0-1.333,0-2,0\n" +
                "\tc-6.695,4.198-26.979-4.357-29-3c-6.365,4.724-5.744,15.175-11,21c-5.862,6.497-16.573,11.364-21,19c-1.333,4-2.667,8-4,12\n" +
                "\tc-4.481,6.472-12.7,3.025-20,7c-1.627,0.886-4.552,4.559-6,6c-3.786,3.77-11.375,8.541-14,13c-2.033,3.454-1.445,8.336-5,10\n" +
                "\tc-1.667,0-3.333,0-5,0c-2.561,1.756-6.192,0.641-9,0c-0.631-1.754-0.193-0.971-1-2c0.714-2.963,1.828-4.58,3-7c2-0.333,4-0.667,6-1\n" +
                "\tc0-1.333,0-2.667,0-4c-2.076-0.372-1.924-0.242-3-1c-6.751-7.604,3.293-14.149,5-19c0-3.666,0-7.333,0-11\n" +
                "\tc-2.908-2.36-2.597-4.851-7-6c-2.684,3.245-6.295,1.648-10,4c-5.31,3.37-6.314,11.863-10,17c-2.787,3.884-10.164,4.178-13,8\n" +
                "\tc-5.261,7.09-2.757,14.708-12,18c-4.487,3.499-14.108,3.13-22,3c0,0.667,0,1.333,0,2c-2.899,3.902,0.857,2.585,0,7\n" +
                "\tc-0.284,1.459-2.355,2.832-3,5c4.106,2.736,6.613,7.873,11,10c3.052-3.741,10.203-2.262,18-2c0.672,1.294,2.588,2.808,3,4\n" +
                "\tc2.165,6.272-2.081,11.878,3,15c2.787,1.926,8.018,0.687,11,0c0.636-10.486,12.307-14.173,18-20c14.827,5.767,29.977,2.536,44,5\n" +
                "\tc0,0.667,0,1.333,0,2c0,0-1.543,13.305-2,14c0,0.333,0,0.667,0,1c-0.667,0-1.333,0-2,0c-3.953,2.081-4.728-2.044-9-1\n" +
                "\tc0,0-18.881,11.843-19,12c0,1.333,0,2.667,0,4c-1.056,2.117-6.856,7.869-9,9c-2.141,1.221-2.77,0.388-6,0c0,0.333,0,0.667,0,1\n" +
                "\tc1.551,1.995,2.119,5.118,1,7c-1.45,4.891-5.375,8.243-11,9c-1,5-2,10-3,15c5.382,1.348,7.28,5.223,11,7c3.712,1.773,9.58,0.8,13,2\n" +
                "\tc5.983,12.924,18.257,21.32,19,39c9.054,1.124,13.881,6.858,23,9c1.452,6.657,9.692,17.405,8,22c-0.936,3.184-2.864,2.87-4,5\n" +
                "\tc-3.125,5.863,0.156,7.984-9,8c-1.073-0.751-0.946-0.601-3-1c0.163,5.339-2.041,5.693-5,10c12.064-0.544,23.568,2.424,24,13\n" +
                "\tc-2.255,2.847,2.462,6.936,3,14c-1.5,0.774-4.565,1.894-6,3c1.827,2.961,0.102,8.824-2,11c2.667,2.365,3.045,2.627,3,8\n" +
                "\tc-3.179,2.022-7.378,5.257-10,8c-1.667-0.333-3.333-0.667-5-1c-0.476,1.957-1.732,2.142-2,3c0.333,2,0.667,4,1,6\n" +
                "\tc-0.481,1.132-3.481,2.541-4,4c-1.667,4.687,2.125,6.537,0,10c-2.151,3.506-8.081,7.222-10,11c0,1.667,0,3.333,0,5\n" +
                "\tc-1,0.667-2,1.333-3,2c0.906,3.792,2.826,5.165,0,9c-1.703,1.597-4.319,2.378-6,4c2.617,2.953,1.861,8.086,2,13\n" +
                "\tc-2.091,1.122-1.832,1.435-5,2c-1.073-0.751-0.946-0.601-3-1c0,0.333,0,0.667,0,1c1.495,1.624,1.552,2.023,2,5\n" +
                "\tc-1.833,1.285-1.712,1.968-4,3c-1.073,0.752-0.946,0.601-3,1c0.094,3.09,0.141,6.33-1,8c-2.374,7.354-9.645,7.724-14,13\n" +
                "\tc-1.667,0-3.333,0-5,0c-0.547,5.165-3.74,12.364-8,14c-2.385,1.192-4.214-1.061-5,0c-0.885,1.404-1.085,5.607-2,7\n" +
                "\tc-3.675,3.24-10.085,2.853-14,6c-0.667,2-1.333,4-2,6c-2.916,3.147-13.828,9.171-19,10c-1.358-1.262-1.769-1.365-4-2\n" +
                "\tc-0.829,4.422-1.297,6.176-6,7c-2.604-2.871-4.751-4.596-10-5c-0.372,2.076-0.242,1.924-1,3c-2.296,2.146-3.932,2.017-7,1\n" +
                "\tc-0.407,3.907-1.046,5.596-4,7c-3.616,2.493-10.93,1.872-15,1c-1.229-4.014-3.677-6.017-5-10c-0.333,0-0.667,0-1,0\n" +
                "\tc0,5.666,0,11.334,0,17c-1.46,0.854-2.867,1.812-4,3c-2.667-1-5.333-2-8-3c-0.893,8.106-4.466,3.255-9,7\n" +
                "\tc-1.233,1.019-1.381,4.301-3,5c-3.333-0.333-6.667-0.667-10-1c-0.859,0.462-1.446,3.569-3,4c-3.552,0.985-6.054-4-7-2\n" +
                "\tc-7.281,5.646-16.484,10.881-29,11c0,1.667,0,3.333,0,5c-1.458,0.787-3.728,1.898-5,3c0.667,0,1.333,0,2,0\n" +
                "\tc1.975,2.967,5.387,5.641,8,8c-1.137,4.386-3.552,6.077-6,9c1.667,0,3.333,0,5,0c1.342-2.796,1.397-2.459,5-3\n" +
                "\tc1.411,1.514,2.764,2.208,4,4c1.882,2.194,3.186,8.896,1,12c-2.353,4.878-6.748,5.471-8,12c1.238,1.838,1.089,5.704,1,9\n" +
                "\tc-19.2,11.172-20.417,18.963-49,9c-2.621-5.562-4.874-9.561-5-18c1.256-1.259,1.674-3.86,3-5c3.316-2.852,7.888-3.988,11-7\n" +
                "\tc-1.879-2.573-1.37-2.943-1-6c0.333,0,0.667,0,1,0c0-0.333,0-0.667,0-1c6.739-0.339,9.715-3.56,14-5c5.011-1.684,12.239,1.461,16-1\n" +
                "\tc-3.474,0.131-8.032,0.334-10-1c-6.105-8.007-6.446-16.564-6-29c-2.389-0.842-1.645-0.401-3-2c-0.333,0-0.667,0-1,0\n" +
                "\tc0,0.333,0,0.667,0,1c-2.441,2.381-3.678,5.45-7,7c-1.18,0.803-1.681,0.773-4,1c-2.585-3.083-8.255-6.362-12-8\n" +
                "\tc-2.488,1.733-11.105,3.422-12,3c-4.562-0.784-4.936-3.915-8-5c-4.587-1.625-5.327,3.375-10,2c-2.239-0.659-18.15-10.888-19-13\n" +
                "\tc-1.628-2.2-1.917-5.178-2-9c2.091-1.908,3.973-3.995,5-7c-11.339,0.041-14.34-3.791-26-4c-2.047-3.853-3.334-7.425-9-8\n" +
                "\tc-2.678,2.864-12.921,12.611-16,14c-3,0-6,0-9,0c-1.561,0.532-3.43,3.517-5,4c-5.433,1.672-12.073-3.799-15-2\n" +
                "\tc-4.327,2.957-4.98,6.367-12,7c-2.679-3.289-5.488-6.45-11-7c-2.967,4.032-6.667,5.148-14,5c-0.525,11.301,3.329,18.209,4,30\n" +
                "\tc-2.556,1.479-3.146,2.398-7,3c-2.716-2.094-7.542-2.714-11-4c-1.491-3.941-3.091-7.747-5-11c-4.184,2.553-5.629,5.407-12,6\n" +
                "\tc-4.006-2.913-10.178-2.97-13-7c-2.631-3.758-1.762-7.782-6-10c-6.278-4.28-14.502,0.735-15-10c3.5-3.432,7.334-8.952,10-13\n" +
                "\tc-9.581,0.21-12.113-2.901-17-7c1-4,2-8,3-12c-0.321-0.969-3.507-2.704-4-4c-1.153-3.033,3.581-2.217,0-4c-0.924,0.76-22,6-22,6\n" +
                "\tc-1.32-0.453-1.252-1.639-2-3c-1.569-2.863,0.547-2.733,1-5c0.558-2.792-2.556-8.752-1-13c0.182-0.495,17-25,17-25\n" +
                "\tc1.333,0,2.667,0,4,0c1.073,0.752,0.946,0.601,3,1c1.225-2.281,1.638-2.251,2-6c2.799-4.083,5.563-28.959,2-33\n" +
                "\tc-3.212-3.642-7.579,0.322-10-5c-4.721-8.282,1.123-19.583-13-21c0.103,6.631-0.895,10.964-2,16c-0.667,0-1.333,0-2,0\n" +
                "\tc-5.128,2.793-21.783-9.508-25-13c-15.836,0.584-21.493,6.664-32,11c-4.332,1.788-10.228-0.341-15,2c-2.333,3.333-4.667,6.667-7,10\n" +
                "\tc-4.05,3.109-28.047,8.823-36,4c-9.454-3.479-5.58-13.31-11-17c-2.567-1.876-3.556-0.617-5-4c-1.221-2.141-0.388-2.77,0-6\n" +
                "\tc-17.002-0.382-23.053-9.795-38-12c-3.733,4.146-12.713,18.275-17,20c-5.343,2.926-10.766-6.05-11-12c2-1.667,4-3.333,6-5\n" +
                "\tc-1.021-0.804-0.274-0.355-2-1c-8.331-4.938-23.544,4.72-34,0c-1.862-0.841-4.127-5.202-6-6c-5,0.333-10,0.667-15,1\n" +
                "\tc-3-3.333-6-6.667-9-10c-2.86-1.97-13.241-3.324-15-5c-1-2.667-2-5.333-3-8c-2-0.333-4-0.667-6-1c-7.571-3.768-10.401-9.286-14-17\n" +
                "\tc-2.59,0.507-4.429,0.921-8,1c-7.101-11.315-18.194-17.514-27-27c-3.877-4.177-1.349-9.034-9-10c0-0.333,0-0.667,0-1\n" +
                "\tc-0.333,0-0.667,0-1,0c-0.816,3.516-1.99,5.634-5,7c-1.295,0.877-2.467,0.895-5,1c-3.253-3.467-7.309-9.158-11-12\n" +
                "\tc-4.86-3.743-11.537-6.993-15-12c-2.338-3.38-3.278-9.262-7-11c-2.333,0-4.667,0-7,0c-4.08-1.021-4.523-4.481-7-7\n" +
                "\tc-0.318-9.33,3.691-11.469,5-17c0.65-2.749-7.331-14.176,2-19c0.968-0.251,0.379-0.784,1,0c2.873,1.12,1.842,0.174,3,3\n" +
                "\tc0.803,1.18,0.773,1.681,1,4c1.667,0,3.333,0,5,0c2.198-3.306,4.188-3.93,5-9c-4.579-4.794-7.889-14.108-8-23\n" +
                "\tc3.047-3.114,6.711-8.431,8-13c-18.305-2.946-6.315-19.446-14-30c-6.359-5.473-17.788-5.404-23-12c-2.404-3.684,0.808-3.948-7-4\n" +
                "\tc-0.771-0.682-2.232-1.311-3-2c-5.966-6.336-0.758-14.412,1-21c-3.287-2.105-5.788-7.476-9-9c-2.333,0-4.667,0-7,0\n" +
                "\tc-1.804-0.777-5.725-4.347-7-6c-1.879-2.573-1.37-2.943-1-6c3.728-0.758,10.095-1.634,14-3c0.369-5.037,2.08-8.971,3-13\n" +
                "\tc-0.333-5.333-0.667-10.667-1-16c-1.826-1.182-2.801-2.192-4-4c-4.419,2.981-4.009,4.293-10,4c-2.697-3.475-4.01-3.101-4-10\n" +
                "\tc7.644-8.991,0.608-11.982,4-18c2.591-7.749,13.615-15.877,24-16c3.327,2.434,8.816,3.78,14,4c2.428-5.079,5.181-5.356,13-5\n" +
                "\tc1.021,0.804,0.274,0.355,2,1c0,0.667,0,1.333,0,2c0.961,1.417,0.976,3.273,1,6c2.333,0,4.667,0,7,0c3.282-4.984,8.466-9.33,15-11\n" +
                "\tc4,0,8,0,12,0c1.524-0.508,3.459-3.599,5-4c6.666,1,13.334,2,20,3c1.667-2,3.333-4,5-6c7.333-0.333,14.667-0.667,22-1\n" +
                "\tc2.281-3.373,6.7-4.784,9-8c2.954-4.13,1.896-9.868,7-12c1.68-0.994,2.29-0.103,4-1c4.138-5.228,4.348-27.863,6-37\n" +
                "\tc-1.635-4.532-5.892-5.76-7-12c2.281-1.225,2.251-1.638,6-2c8.95-5.889,35.351,3.801,42,5c0.333-1,0.667-2,1-3\n" +
                "\tc-2.291-3.051-2.402-7.945-2-11c7.918-6.27,16.976-25.972,27-28c7.981,7.703,19.465,13.002,35,13c4.722-6.679,7.577-15.526,10-25\n" +
                "\tc6.411-3.718,12.299-7.087,21-9c1.625-4.02,2.788-9.346,7-11c3.439-2.3,12.978-1.562,16-1c1.333,5.666,2.667,11.334,4,17\n" +
                "\tc1.968,2.356,6.167,3.387,8,6c1.723,2.458,1.564,5.382,4,7c7.292,4.842,17.663,2.13,21,11c1.16,1.525,9.335,30.518,9,32\n" +
                "\tc-2.385,10.56-12.559,16.812-10,31c10.821,3.679,27.508,0.705,38,5c5.803,2.376,13.95,6.255,19,10c2.174,1.612,7.411,10.597,8,11\n" +
                "\tc2,0,4,0,6,0c1.521,1.051,4.915,1.586,7,2c0.773,2.48,0.428,8.245,2,11c0.937,1.642,4.942,2.224,6,4c4.073,6.838,2.707,21.645,12,23\n" +
                "\tc5.65-2.186,8.204,4.294,12,6c1.195,0.537,3.376-2.468,6-2c4.753,0.847,11.925,3.688,17,5c17.805,4.602,36.622-4.251,53,0\n" +
                "\tc15.831,4.109,25.476,16.189,41,21c8.466,2.624,14.656-0.82,23-1c2.409,4.354,3.793,5.24,11,5c14.747-21.579,50.938-20.052,85-20\n" +
                "\tc2.15-5.421,7.903-4.866,11-9c4.176-5.574,7.324-14.124,13-18c6.421-4.385,13.194-0.476,14-11c-3.593-0.955-3.784-2.018-6-4\n" +
                "\tc-0.324-9.037,0.962-13.492,3-21c1.758-1.081,3.618-2.516,5-4c11.587,0.117,19.133,8.588,30,6c3.066-0.73,6.524-3.102,10-4\n" +
                "\tc4.074-8.68,8.177-12.183,18-15c4.021-1.153,7.031-0.025,10-2c6.369-4.236,3.618-17.627,8-22c4.333-1,8.667-2,13-3\n" +
                "\tc6.791-3.218,12.432-9.913,20-12c8.666,0,17.334,0,26,0c-0.333-1.667-0.667-3.333-1-5c-8.766-5.524-18.132-11.469-25-19\n" +
                "\tc-5,0.667-10,1.333-15,2c-1.093,3.382-3.03,4.632-5,7c-13.884-1.922-18.973-5.217-27,4c-0.333,0-0.667,0-1,0c0-0.333,0-0.667,0-1\n" +
                "\tc-3.081-1.038-2.918-0.967-4-4c-2.242-3.452-1.155-12.862,0-17c3.076-11.022,5.645-20.482,6-35c3.426-1.833,8.028-2.115,14-2\n" +
                "\tc3.313,2.747,8.271,6.122,13,7c4.031-5.99,16.11-13.892,17-21c-3.766-4.498,0.732-8.074,2-13c0.333-4.666,0.667-9.334,1-14\n" +
                "\tc2.143-5.685,8.363-11.174,10-17c-0.333-3-0.667-6-1-9c-4.251-1.952-8.888-1.329-10-7c3.573-3.586,4.823-10.074,10-12\n" +
                "\tc3.364-2.899,8.027-1.27,13-3c7.957-2.769,17.292-12.768,31-9c2.119,0.583,5.167,3.425,7,4c6.666,0,13.334,0,20,0\n" +
                "\tc5.383,1.768,7.912,7.909,12,11c19.969,15.098,34.775,35.051,46,59c11.809-0.044,30.033,0.615,40,4c4.791,1.627,6.85,3.829,15,4\n" +
                "\tc0.923,1.834,1.437,6.845,3,9c1.409,1.943,5.619,2.804,7,5c3.618,5.751-1.418,9.797,10,10c4.445-2.858,14.535-2.926,20-4\n" +
                "\tc1.681-3.784,2.997-8.19,4-13c11.556-4.728,11.982-13.898,28-14c1.57,2.958,0.388,6.609,2,11c0.719,1.959,4.398,3.715,5,6\n" +
                "\tc1.499,5.696-4.071,6.689-3,13c3.696,21.782,12.903,57.513-18,57c-1.737-1.322-1.607-1.727-3-1c-5.625,2.724-10.985,7.652-12,15\n" +
                "\tc0.974,0.657,7.474,6.262,8,7c2.321,3.253,8.045,31.258,5,36c-1.075,2.388-1.963,2.736-4,4c2.637,4.102,3.28,3.516,3,9\n" +
                "\tc-1.083,0.909-0.085-0.078-1,1c-2.333,0.333-4.667,0.667-7,1C1111.56,236.117,1107.317,231.968,1102,231z";
        try {
            mPath = svgPathParser.parsePath(pathStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(mPath, mPaint);
    }


}
