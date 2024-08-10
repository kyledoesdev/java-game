package coolgame.Enums;

import java.awt.*;

public enum ScreenSizesEnum {
    SIZE_640x480(new Dimension(640, 480)),
    SIZE_800x600(new Dimension(800, 600)),
    SIZE_1280x720(new Dimension(1280, 720)),
    SIZE_1600x900(new Dimension(1600, 900)),
    SIZE_1920x1080(new Dimension(1920, 1080));

    private final Dimension dimension;

    ScreenSizesEnum(Dimension dimension) {
        this.dimension = dimension;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public static ScreenSizesEnum fromDimension(Dimension dimension) {
        for (ScreenSizesEnum dim : values()) {
            if (dim.getDimension().equals(dimension)) {
                return dim;
            }
        }

        return null;
    }

    public static ScreenSizesEnum fromIndex(int index) {
        return values()[index];
    }

    public static ScreenSizesEnum getMax() {
        ScreenSizesEnum[] values = values();
        return values[values.length - 1];
    }
}
