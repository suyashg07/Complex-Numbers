public class Polar extends ComplexNumber {

    private double r;
    private double theta;
    public Polar(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }
    public double real() {
        if (Math.abs(Math.sin(this.theta)) == 1)
            return 0;
        return this.r*Math.cos(this.theta);
    }

    public double imag() {
        if (Math.abs(Math.cos(this.theta)) == 1)
            return 0;
        return this.r*Math.sin(this.theta);
    }

    public double phase() {
        if (this.theta > Math.PI)
            while(this.theta > Math.PI) this.theta -= 2*Math.PI;
        if (this.theta < -Math.PI)
            while(this.theta < -Math.PI) this.theta += 2*Math.PI;
        return this.theta;
    }

    public double modulus() {
        return Math.abs(this.r);
    }

    public Polar conjugate() {
        return new Polar(this.r, -this.theta);
    }

    /**
     * Returns the complex number in rectangular form.
     * @return  the complex number in rectangular form.
     */
    public Rectangular toComplexRect() {
        return new Rectangular(this.real(), this.imag());
    }

    public String toString() {
        return "" + this.modulus() + "e^" + this.phase() + "i";
    }
}
