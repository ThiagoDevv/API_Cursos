package pessoacurso;

import java.util.Scanner;
import model.bean.Pessoa;
import model.dao.PessoaDao;

public class PessoaCurso {

    public static void main(String[] args) {
        String nome;
        String cpf;
        
        
        Scanner in = new Scanner(System.in);
        Pessoa p = new Pessoa();
        PessoaDao dao = new PessoaDao();
        
        System.out.println("ID: ");
        int id = in.nextInt();
        
        p.setIdPessoa(id);
        
        dao.delete(p);
        
        
        
        
    }
    
}
