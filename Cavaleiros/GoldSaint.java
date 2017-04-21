import java.util.ArrayList;
public class GoldSaint extends Saint {
    public GoldSaint (String nome, String nomeDaConstelacao) throws Exception{
       
        super(nome, nomeDaConstelacao);
        this.armadura = new Armadura (new Constelacao (nomeDaConstelacao), Categoria.OURO);
        this.qtsSentidosDespertados = 7;
        
        String constelacao = getArmadura().getConstelacao().getNomeDaConstelacao();
        if ( !constelacao.equals("Áries") 
        && !constelacao.equals("Touro")
        && !constelacao.equals("Gêmeos")
        && !constelacao.equals("Câncer")
        && !constelacao.equals("Virgem")
        && !constelacao.equals("Leão")
        && !constelacao.equals("Libra")
        && !constelacao.equals("Escorpião")
        && !constelacao.equals("Sagitário")
        && !constelacao.equals("Capricórnio")
        && !constelacao.equals("Aquário")
        && !constelacao.equals("Peixes")) {
            // dar erro
            throw new Exception("Constelação inválida");
        }
    }
}