import br.com.holding.autentication.model.Profile;
import br.com.holding.autentication.model.Role;
import br.com.holding.autentication.model.User;
import br.com.holding.pessoa.model.Pessoa;
import br.com.holding.pessoa.model.PessoaFisica;
import br.com.holding.pessoa.model.PessoaJuridica;
import br.com.holding.sistema.Sistema;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Objects;

public class Main {

        public static PessoaFisica novaPessoa(Long id,String nome, LocalDate nascimento, String cpf) {
            PessoaFisica pf = new PessoaFisica();
            pf.setNome(nome);
            pf.setCpf(cpf);
            pf.setId(id);
            pf.setNascimento(nascimento);
            return pf;
        }
        public static PessoaJuridica novaPessoaJuridica (Long id,String nome, LocalDate nascimento, String cnpj) {
            PessoaJuridica pj = new PessoaJuridica();
            pj.setNome(nome);
            pj.setNascimento(nascimento);
            pj.setId(id);
            pj.setCnpj(cnpj);
            return pj;
        }

        public static User novoUsuario(Long id, String email, String password, Pessoa pessoa) {
            User lg = new User();
            lg.setPessoa(pessoa);
            lg.setId(id);
            lg.setEmail(email);
            lg.setPassword(password);
            return lg;
        }

       public static Profile novoProfile(Long id, String nome){
            Profile profile = new Profile();
            profile.setId(id);
            profile.setNome(nome);
            return profile;
       }

       public static Role novaRole(Long id, String nome, String descricao, Sistema sistema){
           Role rl = new Role();
           rl.setId(id);
           rl.setNome(nome);
           rl.setDescricao(descricao);
           return rl;
       }

       public static Sistema novoSistema(Long id,String nome, String sigla){
            Sistema sist = new Sistema();
            sist.setId(id);
            sist.setNome(nome);
            sist.setSigla(sigla);
            return sist;
       }



    public static void main(String[] args) {
        PessoaFisica lucca = novaPessoa(1234L,"Lucca",LocalDate.of(2004,8,19),"523000893851");
        PessoaJuridica holding = novaPessoaJuridica(1234L,"Holding",LocalDate.of(2023,1,19),"213432");
        User lucca19 = novoUsuario(12345L,"luccarvfreitas@gmail.com","12345",lucca);
        Profile gerente = novoProfile(4444L,"Lucca");
        Sistema mercado = novoSistema(55555L,"Hirota","HR");
        Role gerenciaMercado = novaRole(4424L,"Lucca","Gerencia o mercado", mercado);

        PessoaFisica Luccajr = novaPessoa(732L,"Lucca Junior", LocalDate.of(2023,8,15),"2342345");

        lucca.addFilho(Luccajr);
        holding.addSocio(lucca);
        lucca19.addProfile(gerente);
        gerente.addRole(gerenciaMercado);
        mercado.addResponsavel(lucca);


        var login = JOptionPane.showInputDialog("Digite seu email: ");
        var senha = JOptionPane.showInputDialog("Digite sua senha: ");

        if ( Objects.equals(login,lucca19.getEmail()) && Objects.equals(senha,lucca19.getPassword())){
            System.out.println("Você logou!!");
        } else {
            System.out.println("Email ou senha incorretos Falha no login!");
        }
    }




}