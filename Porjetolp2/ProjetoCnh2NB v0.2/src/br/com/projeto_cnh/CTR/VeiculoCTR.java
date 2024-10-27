/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_cnh.CTR;

import br.com.projeto_cnh.DTO.VeiculoDTO;
import br.com.projeto_cnh.DAO.VeiculoDAO;
import br.com.projeto_cnh.DTO.InstrutorDTO;
import java.sql.ResultSet;
import br.com.projeto_cnh.DAO.ConexaoDAO;

/**
 *
 * @author aluno
 */
public class VeiculoCTR {

    VeiculoDAO veiculoDAO = new VeiculoDAO();

    public String inserirVeiculo(VeiculoDTO veiculoDTO) {
        try {
            if (this.veiculoDAO.inserirVeiculo(veiculoDTO)) {
                return "Veiculo inserido com sucesso.";
            } else {
                return "Veiculo não inserido.";
            }
        } catch (Exception err) {
            System.out.println("Erro VeiculoCTR.inserirVeiculo: " + err.getMessage());
            return "Veiculo não inserido.";
        }
    }

    public boolean inserirInstrutorVeiculo(VeiculoDTO veiculoDTO, InstrutorDTO instrutorDTO) {
        try {
            if (this.veiculoDAO.inserirInstrutorVeiculo(veiculoDTO, instrutorDTO)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception err) {
            System.out.println("Erro VeiculoCTR.inserirInstrutorVeiculo: " + err.getMessage());
            return false;
        }
    }

    public String excluirVeiculo(VeiculoDTO veiculoDTO) {
        try {
            if (this.veiculoDAO.excluirVeiculo(veiculoDTO)) {
                return "Veiculo deletado com sucesso.";
            } else {
                return "Veiculo não deletado.";
            }
        } catch (Exception err) {
            System.out.println("Erro VeiculoCTR.excluirVeiculo: " + err.getMessage());
            return "Veiculo não deletado.";
        }
    }

    public ResultSet consultarVeiculo(VeiculoDTO veiculoDTO, int opcao) {
        ResultSet rs = null;

        rs = veiculoDAO.consultarVeiculo(veiculoDTO, opcao);

        return rs;
    }
    
    public ResultSet consultarInstrutorVeiculo(VeiculoDTO veiculoDTO, int opcao) {
        ResultSet rs = null;

        rs = veiculoDAO.consultarInstrutorVeiculo(veiculoDTO, opcao);

        return rs;
    }
    
   

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

    public String alteraInstrutorVeiculo(VeiculoDTO veiculoDTO, int idsInstrutores[]) {
        try {
            if (this.veiculoDAO.alteraInstrutorVeiculo(veiculoDTO, idsInstrutores)) {
                return "Relação alterada com sucesso";
            } else {
                return "Não foi possivel altear";
            }
        } catch (Exception err) {
            System.out.println("Erro VeiculoCTR.alteraInstrutorVeiculo: " + err.getMessage());
            return "Não foi possivel altear";
        }
    }

}
