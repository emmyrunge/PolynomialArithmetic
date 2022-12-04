/**
 * Monomial class to be used as building blocks for polynomials
 */
public class Monomial implements Comparable<Object>
{
    private int degree;     // immutable degree of the term.  Must be >= 0
    private double coeff;   // coefficient of the term
    // e.g., 3.5x^2 would have degree = 2, and coeff = 3.5, etc

    //<editor-fold defaultstate="collapsed" desc="constructors, getters & setters">
    public Monomial(int degree, double coeff)
    {
        this.degree = degree;
        this.coeff = coeff;
    }

    public Monomial(Monomial orig)
    {
        degree = orig.degree;
        coeff = orig.coeff;
    }

    public int getDegree()
    {
        return degree;
    }

    public double getCoeff()
    {
        return coeff;
    }

    public void setCoeff(double coeff)
    {
        this.coeff = coeff;
    }

    // there is no setter for degree.
    //</editor-fold>

    /**
     * compareTo : compare monomials strictly by their degrees <br>
     * thus, 2x^3 == 5x^3 (both of degree 3)
     *
     * @param other Monomial to compare this one to
     * @return int - difference in degrees
     * @throws NullPointerException if other is null
     * @throws ClassCastException   if other cannot be cast to Monomial
     */
    public int compareTo(Object other) throws NullPointerException, ClassCastException
    {
        if (other == null)
        {
            throw new NullPointerException();
        }
        if (other instanceof Monomial)
        {
            Monomial otherM = (Monomial) other;
            return degree - otherM.degree;
        } else
        {
            throw new ClassCastException();
        }
    }

    public boolean equals(Object other)
    {

        return other != null
                &&
                other instanceof Monomial
                &&
                ((Monomial) other).degree == degree;
    }

    public String toString()
    {
        String strRet = "" + coeff
                + (degree == 0
                ? ""
                : degree == 1
                ? "x"
                : ("x^" + degree));
        return strRet;
    }
}
