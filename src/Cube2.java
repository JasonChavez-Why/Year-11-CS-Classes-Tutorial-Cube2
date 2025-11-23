public class Cube2 {
    private Cube basicCube;
    private String color;

    public Cube2() {
        basicCube = new Cube();
        this.color = "black";
    }

    public Cube2(int side) {
        this();
        basicCube.setSide(side);
    }

    public Cube2(int side, String color) {
        this();
        basicCube.setSide(side);
        this.color = color;
    }

    public int getSide() {
        return basicCube.getSide();
    }
    public void setSide(int side) {
        basicCube.setSide(side);
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int calculateVolume() {
        return basicCube.calculateVolume();
    }
    public int calculateSurfaceArea() {
        return basicCube.calculateSurfaceArea();
    }
    public boolean equals(Cube2 otherCube) {
        return this.getSide() == otherCube.getSide() && this.color.equals(otherCube.getColor());
    }
    public Cube2 add(Cube2 otherCube) {
        int thisSide = this.getSide();
        int otherSide = otherCube.getSide();
        int newSide = (int) Math.sqrt(thisSide * thisSide + otherSide * otherSide);
        if (Math.pow(thisSide, 2) + Math.pow(otherSide, 2) == Math.pow(newSide, 2)) {
            Cube2 result = new Cube2(newSide, this.color);
            return result;
        } else {
            throw new IllegalArgumentException("You idiot");
        }
    }
    public Cube2 minus(Cube2 otherCube) {
        int thisSide = this.getSide();
        int otherSide = otherCube.getSide();
        int largerSide = Math.max(thisSide, otherSide);
        int smallerSide = Math.min(thisSide, otherSide);
        int newSideSquared = largerSide * largerSide - smallerSide * smallerSide;
        int newSide = (int) Math.sqrt(newSideSquared);
        if (newSide * newSide == newSideSquared && newSide > 0) {
            return new Cube2(newSide, this.color);
        } else {
            throw new IllegalArgumentException("You idiot");
        }
    }
    public String toString() {
        return "Cube{side=" + getSide() + ", color=\"" + color + "\"}";
    }
}