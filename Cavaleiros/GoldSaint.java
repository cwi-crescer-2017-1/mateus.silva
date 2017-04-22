import java.util.ArrayList;
public class GoldSaint extends Saint {
    public GoldSaint (String nome, String nomeDaConstelacao) throws Exception{
        super(nome, new Armadura(new Constelacao (nomeDaConstelacao), Categoria.OURO));
        this.qtsSentidosDespertados = 7;
    }
}