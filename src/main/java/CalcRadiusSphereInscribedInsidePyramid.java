import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Queue;

public class CalcRadiusSphereInscribedInsidePyramid {
    private static final long serialVersionUID = -1;
    private double h, a;
    public CalcRadiusSphereInscribedInsidePyramid(float h, float a) {
        this.h = h;
        this.a = a;
    }

    /**
     * rs = a*h / (a + sqrt(pow(a,2) + pow(h,2)*4)
     * @return
     */
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
