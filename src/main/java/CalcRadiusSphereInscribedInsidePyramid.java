import java.math.BigDecimal;
import java.math.MathContext;

public class CalcRadiusSphereInscribedInsidePyramid {

    private double h, a;
    public CalcRadiusSphereInscribedInsidePyramid(float h, float a) {
        this.h = h;
        this.a = a;
    }
    public float calcRadiusSphereInscribedInside() {
        BigDecimal h = new BigDecimal(Double.toString(this.h));
        BigDecimal a = new BigDecimal(Double.toString(this.a));
        BigDecimal rs = a.multiply(h).divide(a.add((a.pow(2).add(h.pow(2).multiply(new BigDecimal("4.0"))))), new MathContext(3));
        return rs.floatValue();
    }
    public static void main(String[] args) {
        CalcRadiusSphereInscribedInsidePyramid pyramid = new CalcRadiusSphereInscribedInsidePyramid(4, 6);
        System.out.println(String.format("Radius Sphere Inscribed inside pyramid is %s", pyramid.calcRadiusSphereInscribedInside()));
    }
}
