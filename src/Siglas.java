public class Siglas implements Comparable<Siglas> {

    private String siglasEstado;
    private Integer populacao;

    public Siglas(String siglaEstado, Integer populacao){
        this.siglasEstado = siglaEstado;
        this.populacao = populacao;

    }

    public String getSiglasEstado() {
        return siglasEstado;
    }

    public void setSiglasEstado(String siglasEstado) {
        this.siglasEstado = siglasEstado;
    }

    public Integer getPopulacao() {
        return populacao;
    }

    public void setPopulacao(Integer populacao) {
        this.populacao = populacao;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((siglasEstado == null) ? 0 : siglasEstado.hashCode());
        result = prime * result + ((populacao == null) ? 0 : populacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Siglas other = (Siglas) obj;
        if (siglasEstado == null) {
            if (other.siglasEstado != null)
                return false;
        } else if (!siglasEstado.equals(other.siglasEstado))
            return false;
        if (populacao == null) {
            if (other.populacao != null)
                return false;
        } else if (!populacao.equals(other.populacao))
            return false;
        return true;
    }
    
    @Override
    public int compareTo(Siglas o){
        return Integer.compare(this.getPopulacao(), o.getPopulacao());
    }

}
