package net.colindodd.gradientlayout;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class GradientRelativeLayout extends RelativeLayout {

    private final GradientBackground gradientBackground;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GradientRelativeLayout( final Context context,
                                   final AttributeSet attrs,
                                   final int defStyleAttr,
                                   final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.gradientBackground = new GradientBackground(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public GradientRelativeLayout( final Context context,
                                   final AttributeSet attrs,
                                   final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.gradientBackground = new GradientBackground(context, attrs);
    }

    public GradientRelativeLayout(final Context context,
                                  final AttributeSet attrs) {
        super(context, attrs);
        this.gradientBackground = new GradientBackground(context, attrs);
    }

    /**
     * <p>Configure the gradient background for this layout.</p>
     * @param startColor The start color for the gradient
     * @param endColor The end color for the gradient
     * @param orientation The orientation for the gradient {@link  android.graphics.drawable.GradientDrawable.Orientation  GradientDrawable.Orientation}
     */
    public void setGradientBackgroundConfig(final int startColor, final int endColor, final GradientDrawable.Orientation orientation) {
        this.gradientBackground
                .setStartColor(startColor)
                .setEndColor(endColor)
                .setOrientation(orientation)
                .generate();
    }

    /**
     * <p>Configure the start color for the gradient background for this layout.</p>
     * @param startColor The start color for the gradient
     */
    public GradientRelativeLayout setStartColor(final int startColor) {
        this.gradientBackground.setStartColor(startColor).generate();
        return this;
    }

    /**
     * <p>Configure the end color for the gradient background for this layout.</p>
     * @param endColor The end color for the gradient
     */
    public GradientRelativeLayout setEndColor(final int endColor) {
        this.gradientBackground.setEndColor(endColor).generate();
        return this;
    }

    /**
     * <p>Configure the top left corner radius</p>
     * @param radius The radius to set
     */
    public GradientRelativeLayout setRadiusCornerTopLeft(final float radius) {
        this.gradientBackground.setRadiusCornerTopLeft(radius);
        return this;
    }

    /**
     * <p>Configure the top right corner radius</p>
     * @param radius The radius to set
     */
    public GradientRelativeLayout setRadiusCornerTopRight(final float radius) {
        this.gradientBackground.setRadiusCornerTopRight(radius);
        return this;
    }

    /**
     * <p>Configure the top left corner radius</p>
     * @param radius The radius to set
     */
    public GradientRelativeLayout setRadiusCornerBottomRight(final float radius) {
        this.gradientBackground.setRadiusCornerBottomRight(radius);
        return this;
    }

    /**
     * <p>Configure the top left corner radius</p>
     * @param radius The radius to set
     */
    public GradientRelativeLayout setRadiusCornerBottomLeft(final float radius) {
        this.gradientBackground.setRadiusCornerBottomLeft(radius);
        return this;
    }

    /**
     * <p>Configure the orientation for the gradient background for this layout.</p>
     * @param orientation The orientation for the gradient {@link  android.graphics.drawable.GradientDrawable.Orientation  GradientDrawable.Orientation}
     */
    public GradientRelativeLayout setOrientation(final GradientDrawable.Orientation orientation) {
        this.gradientBackground.setOrientation(orientation).generate();
        return this;
    }

    @Override
    protected void onLayout(final boolean changed,
                            final int left,
                            final int top,
                            final int right,
                            final int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        setBackground();
    }

    private void setBackground() {
        final GradientDrawable background = this.gradientBackground.generate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(background);
        } else {
            this.setBackgroundDrawable(background);
        }
    }
}
