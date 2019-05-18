package gerador_provas.control;

import gerador_provas.dao.OrigemDAO;
import gerador_provas.model.Origem;

public class OrigemController {
	
	public int insere(Origem origem) {
		OrigemDAO origemDAO = new OrigemDAO();
		Origem resultado = origemDAO.pesquisar(origem);
		
		if(resultado.getOrigem().equals(origem.getOrigem()) && resultado.getAno() == origem.getAno() ) {
			return resultado.getIdorigem();
		}
		else {
			origemDAO.cadastrar(origem);
			Origem resul = origemDAO.pesquisar(origem);
			return resul.getIdorigem();
		}
	}
}
