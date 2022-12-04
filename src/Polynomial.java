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
     * e.g. if poly is 1 + 2x  <br>
     * then addTerm(3x) should result in poly being 1 + 5x
     *
     * @param term Monomial to be added
     */
    public void addTerm(Monomial term)
    {
        boolean foundAndAdded = false;
        Iterator<Monomial> iterator = poly.ascIterator();
        while (iterator.hasNext())
        {
            Monomial current = iterator.next();

            if (current.compareTo(term) == 0)
            {
                double theCoefficient = current.getCoeff();
                theCoefficient += term.getCoeff();
                current.setCoeff(theCoefficient);

                foundAndAdded = true;

            }
        }
        if(!foundAndAdded)
        {
            poly.insert(term);
        }
    }


    /**
     * mutator addPoly: add another polynomial to this one e.g. <br>
     * if our poly is 1 + 2x <br>
     * and the other is 3 + x^2 <br>
     * then addPoly should transform our poly to 4 + 2x + x^2
     *
     * @param other Polynomial to add to this one
     */
    public void addPoly(Polynomial other)
    {
        Iterator<Monomial> iterator = other.poly.ascIterator();
        while (iterator.hasNext())
        {
            addTerm(iterator.next());
        }
    }

    /**
     * multiply this polynomial by other <br>
     * for example if this is 1+2x+3x^2 and other = 1 -3x^2, <br>
     * then this should become 1+2x-6x^3-9x^4
     *
     * @param other Polynomial to multiply this one by
     */
    public void multiplyBy(Polynomial other)
    {
        Polynomial tempPoly = new Polynomial();
        Iterator<Monomial> polyIterator = poly.ascIterator();

        while(polyIterator.hasNext())
        {
            Monomial curr = polyIterator.next();
            tempPoly.addTerm(curr);
            poly.remove(curr);
        }

        Iterator<Monomial> currIterator = tempPoly.poly.ascIterator();
        while (currIterator.hasNext())
        {
            Iterator<Monomial> iterator = other.poly.ascIterator();
            Monomial curr = currIterator.next();

            while (iterator.hasNext())
            {
                Monomial otherMono = iterator.next();

                double coeffMult = curr.getCoeff();
                coeffMult *= otherMono.getCoeff();

                int degreeAdded = curr.getDegree();
                degreeAdded += otherMono.getDegree();

                Monomial addToPoly = new Monomial(degreeAdded, coeffMult);
                addTerm(addToPoly);

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
