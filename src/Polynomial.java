import java.util.*;

public class Polynomial
{

    private GDSLL<Monomial> poly;

    public Polynomial()
    {
        poly = new GDSLL<Monomial>();
    }

    /**
     * mutator addTerm term to the polynomial poly <br>
     *     e.g. if poly is 1 + 2x  <br>
     *          then addTerm(3x) should result in poly being 1 + 5x
     *
     * @param term Monomial to be added
     */
    public void addTerm(Monomial term)
    {
        boolean foundAndAdded = false;
        //if term has a variable (ex x)
        if(term.getDegree() != 0)
        {
            while (poly.ascIterator().hasNext())
            {
                //iterate through poly and compareTo each mono
                if(poly.ascIterator().next().compareTo(term) == 0)
                //if compareTo returns 0 (no difference in degrees ex: x^4 and 3x^4 == true)
                //add together, set foundAndAdded true;
                {
                    double theCoefficient = poly.ascIterator().next().getCoeff();
                    theCoefficient = poly.ascIterator().next().getCoeff() + term.getCoeff();
                    foundAndAdded = true;

                }
                else
                {
                    //else if it is a coefficient (have no variable ex: n)
                    //check via compareTo method
                    //add coefficients together, set foundAndAdded true;
                    while(poly.ascIterator().hasNext())
                    {
                        if(poly.ascIterator().next().getDegree() == 0)
                        {
                            double theCoefficient = poly.ascIterator().next().getCoeff();
                            theCoefficient = poly.ascIterator().next().getCoeff() + term.getCoeff();
                            foundAndAdded = true;
                        }
                    }
                }
                //if foundAndAdded false
                //insert term to end of poly
                if(!foundAndAdded)
                {
                    poly.insert(term);
                }
            }
        }

    }

    /**
     * mutator addPoly: add another polynomial to this one e.g. <br>
     *     if our poly is 1 + 2x <br>
     *        and the other is 3 + x^2 <br>
     *     then addPoly should transform our poly to 4 + 2x + x^2
     *
     * @param other Polynomial to add to this one
     */
    public void addPoly(Polynomial other)
    {
        //iterate through poly other
        while(other.poly.ascIterator().hasNext())
        {
            addTerm(other.poly.ascIterator().next());
        }
        // for every mono in poly call addTerm method

    }

    /**
     * multiply this polynomial by other <br>
     * for example if this is 1+2x+3x^2 and other = 1 -3x^2, <br>
     * then this should become 1+2x-6x^3-9x^4
     * @param other Polynomial to multiply this one by
     */
    public void multiplyBy(Polynomial other)
    {
        //iterate through this poly
        while(other.poly.ascIterator().hasNext())
        {
            //for every this mono iterate through other poly
            while(other.poly.ascIterator().hasNext())
            {
                //multiply this.mono by every other.mono
                double thisMultiplied = poly.ascIterator().next().getCoeff();
                thisMultiplied = poly.ascIterator().next().getCoeff() * other.poly.ascIterator().next().getCoeff();

                //multiply coefficients tog and add degrees of variables tog
                //using getCoeff and getDegree
                double degreeAdded = poly.ascIterator().next().getDegree();
                degreeAdded = poly.ascIterator().next().getDegree() * other.poly.ascIterator().next().getDegree();
            }
        }


    }

    public String toString()
    {
        String strRet = "";
        if (poly != null)
        {
            Iterator<Monomial> it = poly.ascIterator();
            while (it.hasNext())
            {
                Monomial term = it.next();
                strRet += term.toString();
                strRet += " + ";
            }
            strRet = strRet.substring(0, strRet.length() - 3); // eat last " + "
        }
        return strRet;
    }

}
