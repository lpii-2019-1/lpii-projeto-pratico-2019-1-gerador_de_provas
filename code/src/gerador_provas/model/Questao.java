package gerador_provas.model;



public class Questao
{
  private String enunciado;
  private String origem;
  private String area;
  private String disciplina;
  private String imagem;
  private Alternativa[] alternativa;
  
  
  public String getEnunciado() { return enunciado; }
  
  public void setEnunciado(String enunciado) {this.enunciado = enunciado; }
  
  public String getOrigem() { return origem; }
  
  public void setOrigem(String origem) { this.origem = origem; }
  
  public String getArea() { return area; }
  
  public void setArea(String area) { this.area = area; }
  
  public String getDisciplina() { return disciplina; }
  
  public void setDisciplina(String disciplina) { this.disciplina = disciplina; }
  
  public String getImagem() { return imagem; }
  
  public void setImagem(String imagem) { this.imagem = imagem; }
  
  public Alternativa[] getAlternativa() { return alternativa;}
  
  public void setAlternativa(Alternativa[] alternativa) { this.alternativa = alternativa; }
  


  private Questao(String enunciado, Alternativa[] alternativa, String origem, String area, String disciplina) {
	    setEnunciado(enunciado);
	    setAlternativa(alternativa);
	    setArea(area);
	    setDisciplina(disciplina);
	    setOrigem(origem);
  }  
  
}