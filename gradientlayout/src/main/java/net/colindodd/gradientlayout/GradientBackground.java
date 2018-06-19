package net.colindodd.gradientlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;

public class GradientBackground {

    private int startColor;
    private int endColor;
    private GradientDrawable.Orientation orientation;
    private float radiusCornerTopLeft = 0;
    private float radiusCornerTopRight = 0;
    private float radiusCornerBottomRight = 0;
    private float radiusCornerBottomLeft = 0;

    public GradientBackground(final Context context, final AttributeSet attrs) {
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.GradientLayout, 0, 0);
        this.startColor = a.getColor(R.styleable.GradientLayout_start_color, -1);
        this.endColor = a.getColor(R.styleable.GradientLayout_end_color, -1);

        this.radiusCornerTopLeft = a.getFloat(R.styleable.GradientLayout_radius_corner_top_left,0);
        this.radiusCornerTopRight = a.getFloat(R.styleable.GradientLayout_radius_corner_top_right,0);
        this.radiusCornerBottomLeft = a.getFloat(R.styleable.GradientLayout_radius_corner_bottom_left,0);
        this.radiusCornerBottomRight = a.getFloat(R.styleable.GradientLayout_radius_corner_bottom_right,0);

        final int attrOrientation = a.getInt(R.styleable.GradientLayout_orientation, 0);
        this.orientation = intToOrientation(attrOrientation);
        a.recycle();
    }

    public GradientBackground setStartColor(final int startColor) {
        this.startColor = startColor;
        return this;
    }

    public GradientBackground setEndColor(final int endColor) {
        this.endColor = endColor;
        return this;
    }

    public GradientBackground setOrientation(final GradientDrawable.Orientation orientation) {
        this.orientation = orientation;
        return this;
    }

    public GradientBackground setRadiusCornerTopLeft(final float radius) {
        this.radiusCornerTopLeft = radius;
        return this;
    }
    public GradientBackground setRadiusCornerTopRight(final float radius) {
        this.radiusCornerTopRight = radius;
        return this;
    }
    public GradientBackground setRadiusCornerBottomRight(final float radius) {
        this.radiusCornerBottomRight = radius;
        return this;
    }
    public GradientBackground setRadiusCornerBottomLeft(final float radius) {
        this.radiusCornerBottomLeft = radius;
        return this;
    }



    public GradientDrawable generate() {
        populateMissingColors();
        final int colors[] = {this.startColor, this.endColor};
        final GradientDrawable.Orientation validOrientation = this.orientation == null
                ? GradientDrawable.Orientation.TOP_BOTTOM
                : this.orientation;
        GradientDrawable drawable = new GradientDrawable(validOrientation, colors);
        float[] radii = new float[8];
        radii[0] = radiusCornerTopLeft;
        radii[1] = radiusCornerTopLeft;
        radii[2] = radiusCornerTopRight;
        radii[3] = radiusCornerTopRight;
        radii[4] = radiusCornerBottomRight;
        radii[5] = radiusCornerBottomRight;
        radii[6] = radiusCornerBottomLeft;
        radii[7] = radiusCornerBottomLeft;
        drawable.setCornerRadii(radii);
        return drawable;
    }

    private GradientDrawable.Orientation intToOrientation(final int original) {
        switch (original) {
            case 1:
                return GradientDrawable.Orientation.TR_BL;
            case 2:
                return GradientDrawable.Orientation.RIGHT_LEFT;
            case 3:
                return GradientDrawable.Orientation.BR_TL;
            case 4:
                return GradientDrawable.Orientation.BOTTOM_TOP;
            case 5:
                return GradientDrawable.Orientation.BL_TR;
            case 6:
                return GradientDrawable.Orientation.LEFT_RIGHT;
            case 7:
                return GradientDrawable.Orientation.TL_BR;
            case 0:
            default:
                return GradientDrawable.Orientation.TOP_BOTTOM;
        }
    }

    private void populateMissingColors() {
        if (this.endColor == -1 && this.startColor == -1) {
            this.startColor = Color.RED;
        }

        if (this.endColor == -1) {
            this.endColor = lighter(this.startColor, 0.5f);
            return;
        }

        if (this.startColor == -1) {
            this.startColor = lighter(this.endColor, 0.5f);
        }
    }

    private int lighter(final int color, final float factor) {
        final int red = (int) ((Color.red(color) * (1 - factor) / 255 + factor) * 255);
        final int green = (int) ((Color.green(color) * (1 - factor) / 255 + factor) * 255);
        final int blue = (int) ((Color.blue(color) * (1 - factor) / 255 + factor) * 255);
        return Color.argb(Color.alpha(color), red, green, blue);
    }
}
