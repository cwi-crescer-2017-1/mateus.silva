

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GolpearTest {
    @Test
    public void golpearUmaVezComArmaduraOuroVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
    Golpe golpe1 = new Golpe ("Chifre atômico", 20);
    mu.aprenderGolpe(golpe1);
    mu.vestirArmadura();
    Golpear golpear = new Golpear (mu, seiya);
    golpear.executar();
    assertEquals (20,seiya.getVida(), 0.1);
}
    @Test
    public void golpearUmaVezComArmaduraPrataVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
    Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 20);
    seiya.aprenderGolpe(golpe1);
    seiya.vestirArmadura();
    Golpear golpear = new Golpear (seiya, mu);
    golpear.executar();
    assertEquals (40,mu.getVida(), 0.1);
}
    @Test
    public void golpearUmaVezComArmaduraBronzeVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    BronzeSaint shina = new BronzeSaint ("Shina", "Pégaso");
    Golpe golpe1 = new Golpe ("Cobrinha", 20);
    shina.aprenderGolpe(golpe1);
    shina.vestirArmadura();
    Golpear golpear = new Golpear (shina, mu);
    golpear.executar();
    assertEquals (60,mu.getVida(), 0.1);
}
   @Test
    public void golpear3vezesComArmaduraOuroVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
    Golpe golpe1 = new Golpe ("Chifre atômico", 10);
    Golpe golpe2 = new Golpe ("Chifre galático", 5);
    Golpe golpe3 = new Golpe ("Chifrada", 2);
    mu.aprenderGolpe(golpe1);
    mu.aprenderGolpe(golpe2);
    mu.aprenderGolpe(golpe3);
    mu.vestirArmadura();
    Golpear golpear = new Golpear (mu, seiya);
    golpear.executar();
    golpear.executar();
     golpear.executar();
    assertEquals (32,seiya.getVida(), 0.1);
}
    @Test
    public void golpear5VezezesComArmaduraPrataVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
    Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 10);
    Golpe golpe2 = new Golpe ("Cometa de Pégasus", 5);
    Golpe golpe3 = new Golpe ("Chute de Pégasus", 2);
    seiya.aprenderGolpe(golpe1);
    seiya.aprenderGolpe(golpe2);
    seiya.aprenderGolpe(golpe3);
    seiya.vestirArmadura();
    Golpear golpear = new Golpear (seiya, mu);
    golpear.executar();
    golpear.executar();
    golpear.executar();
    golpear.executar();
    golpear.executar();
    assertEquals (4,mu.getVida(), 0.1);
}
    @Test
    public void golpearduasVezesComArmaduraBronzeVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    BronzeSaint shina = new BronzeSaint ("Shina", "Pégaso");
    Golpe golpe1 = new Golpe ("Cobrinha", 20);
    shina.aprenderGolpe(golpe1);
    shina.vestirArmadura();
    Golpear golpear = new Golpear (shina, mu);
    golpear.executar();
    golpear.executar();
    assertEquals (20,mu.getVida(), 0.1);
}
   @Test
    public void golpearSemAprenderGolpe ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
    assertEquals (100,mu.getVida(), 0.1);
}
   @Test
    public void golpearUmaVezSemArmaduraOuroVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
    Golpe golpe1 = new Golpe ("Chifre atômico", 20);
    mu.aprenderGolpe(golpe1);
    Golpear golpear = new Golpear (mu, seiya);
    golpear.executar();
    assertEquals (80,seiya.getVida(), 0.1);
}
    @Test
    public void golpear5VezezesSemArmaduraPrataVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    SilverSaint seiya = new SilverSaint ("Seiya", "Pégaso");
    Golpe golpe1 = new Golpe ("Meteoro de Pégasus", 10);
    Golpe golpe2 = new Golpe ("Cometa de Pégasus", 5);
    Golpe golpe3 = new Golpe ("Chute de Pégasus", 2);
    seiya.aprenderGolpe(golpe1);
    seiya.aprenderGolpe(golpe2);
    seiya.aprenderGolpe(golpe3);
    Golpear golpear = new Golpear (seiya, mu);
    golpear.executar();
    golpear.executar();
    golpear.executar();
    golpear.executar();
    golpear.executar();
    assertEquals (68,mu.getVida(), 0.1);
}
    @Test
    public void golpearduasVezesSemArmaduraBronzeVestida ()throws Exception {
    GoldSaint mu = new GoldSaint("Mu", "Touro");
    BronzeSaint shina = new BronzeSaint ("Shina", "Pégaso");
    Golpe golpe1 = new Golpe ("Cobrinha", 20);
    shina.aprenderGolpe(golpe1);
    Golpear golpear = new Golpear (shina, mu);
    golpear.executar();
    golpear.executar();
    assertEquals (60,mu.getVida(), 0.1);
}
}
