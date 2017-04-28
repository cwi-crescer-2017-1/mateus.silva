

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ContraAtaqueTest{
    @Test 
    public void testaContraAtaqueSeValorDoDado1() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shak","Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       Golpe golpe1 = new Golpe ("Velocidade da Luz", 5);
       Golpe golpe2 = new Golpe ("Super Velocidade da Luz",10);
       Golpe golpe3 = new Golpe ("Meteoro de Pégaso",10);
       shaka.aprenderGolpe(golpe1);
       shaka.aprenderGolpe(golpe2);
       seiya.aprenderGolpe(golpe3);
       seiya.perderVida(80);
       ContraAtaqueFalso seiyaContraAtaqueFalso = new ContraAtaqueFalso (shaka, seiya);
       Golpear golpear1 = new Golpear (shaka, seiya);
       Golpear golpear2 = new Golpear (seiya, shaka);
       shaka.adicionarMovimento(golpear1);
       seiyaContraAtaqueFalso.testar(1);
       seiya.adicionarMovimento (seiyaContraAtaqueFalso);
       seiya.adicionarMovimento (golpear2);
       Batalha b = new Batalha(shaka, seiya);
       b.iniciar();
       assertEquals (0, seiya.getVida(), 0.001);
       assertEquals (65, shaka.getVida(), 0.01);
    } 
    @Test 
    public void testaContraAtaqueSeValorDoDado2() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shak","Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       Golpe golpe1 = new Golpe ("Velocidade da Luz", 5);
       Golpe golpe2 = new Golpe ("Super Velocidade da Luz",10);
       Golpe golpe3 = new Golpe ("Meteoro de Pégaso",20);
       shaka.aprenderGolpe(golpe1);
       shaka.aprenderGolpe(golpe2);
       seiya.aprenderGolpe(golpe3);
       shaka.perderVida(50);
       ContraAtaqueFalso shakaContraAtaqueFalso = new ContraAtaqueFalso (seiya, shaka);
       Golpear golpear1 = new Golpear (shaka, seiya);
       Golpear golpear2 = new Golpear (seiya, shaka);
       shaka.adicionarMovimento(golpear1);
       shakaContraAtaqueFalso.testar(2);
       shaka.adicionarMovimento (shakaContraAtaqueFalso);
       seiya.adicionarMovimento (golpear2);            
       Batalha b = new Batalha(shaka, seiya);
       b.iniciar();
       assertEquals (53.75, seiya.getVida(), 0.001);      
       assertEquals (0, shaka.getVida(), 0.01);           
    } 
    @Test 
    public void testaContraAtaqueSeValorDoDado3() throws Exception {
       GoldSaint shaka = new GoldSaint ("Shak","Virgem");
       SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
       Golpe golpe1 = new Golpe ("Velocidade da Luz", 5);
       Golpe golpe2 = new Golpe ("Super Velocidade da Luz",10);
       Golpe golpe3 = new Golpe ("Meteoro de Pégaso",10);
       shaka.aprenderGolpe(golpe1);
       shaka.aprenderGolpe(golpe2);
       seiya.aprenderGolpe(golpe3);
       seiya.perderVida(80);
       ContraAtaqueFalso seiyaContraAtaqueFalso = new ContraAtaqueFalso (shaka, seiya);
       Golpear golpear1 = new Golpear (shaka, seiya);
       Golpear golpear2 = new Golpear (seiya, shaka);
       shaka.adicionarMovimento(golpear1);
       seiyaContraAtaqueFalso.testar(3);
       seiya.adicionarMovimento (seiyaContraAtaqueFalso);
       seiya.adicionarMovimento (golpear2);
       Batalha b = new Batalha(shaka, seiya);
       b.iniciar();
       assertEquals (0, seiya.getVida(), 0.001);    
       assertEquals (90, shaka.getVida(), 0.01);     
    } 
}