package test.java;

import com.example.pt2023_3022_laszlo_bogdan_1.Monomial;
import com.example.pt2023_3022_laszlo_bogdan_1.Operation;
import com.example.pt2023_3022_laszlo_bogdan_1.Polynomial;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOp {
    Operation op=new Operation();
    public Polynomial pol1=new Polynomial();
    public  Polynomial pol2=new Polynomial();
    Polynomial polRes=new Polynomial();
    public Polynomial pol=new Polynomial();
    @BeforeEach
    public void init(){
        pol1.addMonom(new Monomial(2,6.0));
        pol1.addMonom(new Monomial(1,-3.0));
        pol1.addMonom(new Monomial(0,4.0));

        pol2.addMonom(new Monomial(1,5.0));
        pol2.addMonom(new Monomial(0,-3.0));
    }

    @Test
    public void addTest(){
        try{
            pol2.addMonom(new Monomial(1,5.0));
            pol2.addMonom(new Monomial(0,-3.0));
            pol1.addMonom(new Monomial(2,6.0));
            pol1.addMonom(new Monomial(1,-3.0));
            pol1.addMonom(new Monomial(0,4.0));
            polRes.addMonom(new Monomial(0,1.0));
            polRes.addMonom(new Monomial(1,2.0));
            polRes.addMonom(new Monomial(2,6.0));
            pol=op.addPol(pol1,pol2);
        }catch (Exception e){
            throw new RuntimeException();
        }
        assertEquals(polRes,pol);
    }
    @Test
    public void subTest(){
        try{
            polRes.addMonom(new Monomial(0,7.0));
            polRes.addMonom(new Monomial(1,-8.0));
            polRes.addMonom(new Monomial(2,6.0));
            pol=op.subsPol(pol1,pol2);
        } catch (Exception e){
            throw new RuntimeException();
        }
        assertEquals(polRes,pol);
    }
    @Test
    public void mulTest() {
        try {
            polRes.addMonom(new Monomial(0, -12.0));
            polRes.addMonom(new Monomial(1, 20.0));
            polRes.addMonom(new Monomial(2, -15.0));
            polRes.addMonom(new Monomial(3, 30.0));
            pol = op.mulPol(pol1, pol2);
        } catch (Exception e) {
            throw new RuntimeException();
        }
        assertEquals(polRes, pol);
    }
    @Test
    public void derivTest(){
        try{
            polRes.addMonom(new Monomial(1,12.0));
            polRes.addMonom(new Monomial(0,-3.0));
            pol=op.derivPol(pol1);
        } catch (Exception e){
            throw new RuntimeException();
        }
        Assertions.assertEquals(polRes,pol);
    }
    @Test
    public void badDerivTest(){
        try{
            polRes.addMonom(new Monomial(1,12.0));
            polRes.addMonom(new Monomial(0,-3.0));
        } catch (IllegalArgumentException e){
            throw new RuntimeException();
        }
        assertEquals(polRes,op.derivPol(pol1));
    }

}
