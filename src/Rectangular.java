public class Rectangular extends ComplexNumber {
    private double real;
    private double imag;

    public Rectangular(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double real() {
        return this.real;
    }

    public double imag() {
        return this.imag;
    }

    public double phase() {
        if (this.real == 0)
            if (this.imag > 0) return Math.PI/2;
            else if (this.imag < 0) return -Math.PI/2;
            else return 0;
        
        if (this.real < 0) {
            return Math.atan(this.imag/this.real) + this.imag/Math.abs(this.imag) * Math.PI;
        }
        return Math.atan(this.imag/this.real);
    }

    public double modulus() {
        return Math.sqrt(this.real*this.real + this.imag*this.imag);
    }

    public Rectangular conjugate() {
        return new Rectangular(this.real, -this.imag);
    }

    public Polar toComplexPolar() {
        return new Polar(this.modulus(), this.phase());
    }

    @Override
    public String toString() {
        if (imag < 0)
            return "" + this.real + " - " + -this.imag + "i";
        return "" + this.real + " + " + this.imag + "i";
    }
}