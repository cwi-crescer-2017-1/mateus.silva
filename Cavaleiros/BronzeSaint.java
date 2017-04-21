import java.util.ArrayList;
public class BronzeSaint extends Saint{
    public BronzeSaint(String nome, String nomeDaConstelacao) throws Exception{
        super (nome,nomeDaConstelacao);
        this.armadura = new Armadura (new Constelacao (nomeDaConstelacao), Categoria.BRONZE);
        this.qtsSentidosDespertados = 5;
}
}