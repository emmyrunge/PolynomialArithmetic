import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest
{

    private Polynomial polynomial = new Polynomial();


    @org.junit.jupiter.api.Test
    void addTerm()
    {
        Monomial mono = new Monomial(2, 1);
        polynomial.addTerm(mono);

        Monomial mono2 = new Monomial(1, 2);
        polynomial.addTerm(mono2);

        System.out.println(polynomial);
    }

    @org.junit.jupiter.api.Test
    void addPoly()
    {
        Polynomial polyToAdd = new Polynomial();
        Monomial monoToAdd = new Monomial(2, 1);
        Monomial monoToAdd2 = new Monomial(1, 1);
        Monomial monoToAdd3 = new Monomial(2, 3);

        polyToAdd.addTerm(monoToAdd);
        polyToAdd.addTerm(monoToAdd2);
        polyToAdd.addTerm(monoToAdd3);


        polynomial.addPoly(polyToAdd);

        System.out.println(polynomial);
    }

    @org.junit.jupiter.api.Test
    void multiplyBy()
    {
        Monomial mono = new Monomial(2, 1);
        polynomial.addTerm(mono);

        System.out.println(polynomial);

        Polynomial polyToMult = new Polynomial();

        Monomial monoToMult = new Monomial(2, 2);
        Monomial monoToMult2 = new Monomial(1, 1);

        polyToMult.addTerm(monoToMult);
        polyToMult.addTerm(monoToMult2);

        polynomial.multiplyBy(polyToMult);

        System.out.println(polynomial);
    }

    @org.junit.jupiter.api.Test
    void testToString()
    {
        Polynomial polyToAdd = new Polynomial();
        Monomial monoToAdd = new Monomial(2, 1);
        Monomial monoToAdd2 = new Monomial(1, 1);
        Monomial monoToAdd3 = new Monomial(2, 3);

        polyToAdd.addTerm(monoToAdd);
        polyToAdd.addTerm(monoToAdd2);
        polyToAdd.addTerm(monoToAdd3);


        polynomial.addPoly(polyToAdd);

        System.out.println(polynomial);    }
}
