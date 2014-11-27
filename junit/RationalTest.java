import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }

	//my test cases
	//1.
	public void testPlus(){
		assertEquals(new Rational(5,18).plus(new Rational(3,36)),new Rational(13,36));
	}

	//2.
	public void testTimes(){
		assertEquals(new Rational(3,7).times(new Rational(21,9)),new Rational(1,1));
	}

	//3.
	public void testMinus(){
		assertEquals(new Rational(9,7).minus(new Rational(87,3)),new Rational(-582,21));
	}

	//4.
	public void testDivides(){
		assertEquals(new Rational(9,7).divides(new Rational(63,35)),new Rational(5,7));
	}

	//5.
	public void testIsNotLessThan(){
		assertFalse(new Rational(5,18).isLessThan(new Rational(3,36)));
	}

	//6.
	public void testIsLessThan(){
		assertTrue(new Rational(3,36).isLessThan(new Rational(5,18)));
	}

	//7.
	public void testToString(){
		assertEquals(new Rational(2,3).toString(),"2/3");		
	}

	//8.
	public void testsetTolerance(){
		new Rational(1,2).setTolerance(new Rational(5,4));
		assertEquals(new Rational(3,2).getTolerance(),new Rational(5,4));
	}

	//9.
	public void testAbs(){
		assertEquals(new Rational(-13,4).abs(),new Rational(13,4));
	}	

	//10.
	public void testCopyConstructor(){
		assertEquals(new Rational(new Rational(1,2)),new Rational(1,2));	
	}	

	//11.
	public void testMain(){
		String[] args = new String[1];
		new Rational(1,2).main(args);
	}

	//12.
 	public void testCtor1(){
		Rational c = new Rational(12,16);
		assertEquals(c.numerator(),3);
		assertEquals(c.denominator(),4);
	}

	//13.
	public void testgcd(){
		Rational g = new Rational(12,16);
		assertEquals(g.numerator()*4,12);
		assertEquals(g.denominator()*4,16);
	}

    //14.
    public void testCtor2(){
    	Rational r1 = new Rational(1,3);
    	Rational r2 = new Rational(r1);
    	assertEquals(r2.numerator(),1);
    	assertEquals(r2.denominator(),3);
    }
    
    //15.
    public void testDenominator(){
    	Rational r = new Rational(1,0);
    	assertTrue("Denominator cannot be 0",r.denominator()!=0);
    }
    
    //16.
    public void testInEquality1() {
        assertFalse(new Rational(2,3).equals(null));
    }
    
 	//17.
    public void testInEquality2() {
        assertFalse(new Rational(2,3).equals(new Integer(2)));
    }
    
    //18.
    public void testlcm(){
    	Rational p1 = new Rational(1,-3);
    	Rational p2 = new Rational(1,-6);
    	Rational sum = p1.plus(p2);
    	assertEquals(sum,new Rational(-1,2));
    }
    
    //19.
    public void testRoot_upper() {
        Rational s = new Rational( 46341, 1 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
            assert false;
        } catch (IllegalArgumentToSquareRootException e) {
            assert true;
        }
    }
    
    //20.
    public void testRoot_lower() {
        Rational s = new Rational( -1, 1 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
            assert false;
        } catch (IllegalArgumentToSquareRootException e) {
            assert true;
        }
    }
    
    //21.
    public void testRoot1() {
        Rational s = new Rational( 16, 25 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertEquals("Root Computation Method incorrect: sqrt(16/25)",sRoot, new Rational(4,5));
    }
    
    //22.
    public void testMain_basic(){
    	 Rational s = new Rational( 1, 2 );
    	 ByteArrayOutputStream output = new ByteArrayOutputStream();
    	 System.setOut(new PrintStream(output));
    	 Rational.main(new String[]{});
    	 assertTrue(output!=null);
    }
    
    //23.
    public void testPlusOverflow(){
    	Rational p1 = new Rational(2147483647,1);
    	Rational p2 = new Rational(2147483647,1);
    	Rational sum = p1.plus(p2);
    	assertFalse("Integer overflow for addtition not handled",new Rational(-2,1).equals(sum));
    }
    
    
   //24.
    public void testTimesOverflow(){
    	Rational p1 = new Rational(2147483647,1);
    	Rational p2 = new Rational(2,1);
    	Rational prod = p1.times(p2);
    	assertFalse("Integer overflow for multipliation not handled",new Rational(-2,1).equals(prod));
    }
    
    //25.
    public void testMinusOverflow(){
    	Rational p1 = new Rational(3*2147483647,1);
    	Rational p2 = new Rational(2147483647,1);
    	Rational sub = p1.minus(p2);
    	assertFalse("Integer overflow for subtraction not handled",new Rational(-2,1).equals(sub));
    }
    
    //26.
    public void testDivideOverflow(){
    	Rational p1 = new Rational(2147483647,1);
    	Rational p2 = new Rational(1,2147483647);
    	Rational div = p1.divides(p2);
    	assertFalse("Integer overflow for division not handled",new Rational(1,1).equals(div));
    }
    
    //27.
    public void testNr(){
    	System.out.println("\nTesting numerator ");
    	Rational r = new Rational(2147483647*2,1);
    	assertFalse("Nr out of range not handled", r.numerator()==-2);
    	
    }
    
    //28.
    public void testDr(){
    	System.out.println("\nTesting denominator ");
    	Rational r = new Rational(1,2147483647*2);
    	assertFalse("Dr out of range not handled", r.denominator()==-2);
    	
    }


    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
		//new Rational(1,2).main(args);
    }
}
