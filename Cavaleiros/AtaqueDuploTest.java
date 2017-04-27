import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AtaqueDuploTest{
    @Test 
    public void testaAtaqueDuploSeValorDoDadoFor1() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shak","Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       Golpe golpe1 = new Golpe ("Velocidade da Luz", 10);
       shaka.aprenderGolpe(golpe1);
       AtaqueDuploFalso shakaAtaqueDuploFalso  = new AtaqueDuploFalso (shaka, seiya);
       shakaAtaqueDuploFalso.testar(1);
       shakaAtaqueDuploFalso.executar();
       assertEquals (90.0, seiya.getVida(), 0.001);
       assertEquals (95, shaka.getVida(), 0.01);
    } 
    @Test 
    public void testaAtaqueDuploSeValorDoDadoFor2() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shak","Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       Golpe golpe1 = new Golpe ("Velocidade da Luz", 10);
       shaka.aprenderGolpe(golpe1);
       AtaqueDuploFalso shakaAtaqueDuploFalso  = new AtaqueDuploFalso (shaka, seiya);
       shakaAtaqueDuploFalso.testar(2);
       shakaAtaqueDuploFalso.executar();
       assertEquals (90.0, seiya.getVida(), 0.001);
       assertEquals (95, shaka.getVida(), 0.01);
    }  
        @Test 
    public void testaAtaqueDuploValorDoDadoFor3() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shak","Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       Golpe golpe1 = new Golpe ("Velocidade da Luz", 10);
       shaka.aprenderGolpe(golpe1);
       AtaqueDuploFalso shakaAtaqueDuploFalso  = new AtaqueDuploFalso (shaka, seiya);
       shakaAtaqueDuploFalso.testar(3);
       shakaAtaqueDuploFalso.executar();
       assertEquals (80, seiya.getVida(), 0.001);
       assertEquals (100, shaka.getVida(), 0.01);
    }  
}