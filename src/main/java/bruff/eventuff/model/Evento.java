package bruff.eventuff.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    
    @ManyToMany
    @JoinTable(
        name = "evento_palestrante",
        joinColumns = @JoinColumn(name = "evento_id"),
        inverseJoinColumns = @JoinColumn(name = "pessoa_id")
    )
    private List<Pessoa> palestrantes;

    private LocalDate data;
    private LocalTime horario;
    private String categoria;
    private int vagas;
    @ManyToMany
    @JoinTable(
        name = "evento_inscrito",
        joinColumns = @JoinColumn(name = "evento_id"),
        inverseJoinColumns = @JoinColumn(name = "pessoa_id")
    )
    private List<Pessoa> inscritos; //mudar tipo Pessoa para Usuário que na vdd herda Pessoa

    public Evento(){

    }
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Pessoa> getPalestrantes() {
        return palestrantes;
    }

    public void setPalestrantes(List<Pessoa> palestrantes) {
        this.palestrantes = palestrantes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public List<Pessoa> getInscritos() {
        return inscritos;
    }

    public void setInscritos(List<Pessoa> inscritos) {
        this.inscritos = inscritos;
    }
}
