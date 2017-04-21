import java.util.ArrayList;
public class SilverSaint extends Saint {
    public SilverSaint (String nome, String nomeDaConstelacao) throws Exception{
        super (nome, nomeDaConstelacao);
        this.armadura = new Armadura (new Constelacao (nomeDaConstelacao), Categoria.PRATA);
        this.qtsSentidosDespertados = 6;
    }
}