/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto_cnh.DAO;

import br.com.projeto_cnh.DTO.VeiculoDTO;
import br.com.projeto_cnh.DTO.InstrutorDTO;
import java.sql.*;

/**
 * @author Henrique Hyonemoto
 * @author Marina Nakashima
 */
public class VeiculoDAO {

    public VeiculoDAO() {

    }

    public ResultSet rs = null;
    Statement stmt = null;
    Statement stml = null;

    public boolean inserirVeiculo(VeiculoDTO veiculoDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comandoVeiculo = "INSERT INTO veiculo (placa, modelo, tipo) "
                    + "VALUES ("
                    + "'" + veiculoDTO.getPlaca() + "',"
                    + "'" + veiculoDTO.getModelo() + "',"
                    + "'" + veiculoDTO.getTipo() + "')";

            stmt.execute(comandoVeiculo);

            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception err) {
            System.out.println("Erro VeiculoDAO.inserirVeiculo: " + err.getMessage());
            return false;
        } finally {
            ConexaoDAO.ConectDB();
        }
    }

    public boolean inserirInstrutorVeiculo(VeiculoDTO veiculoDTO, InstrutorDTO instrutorDTO) {
        try {
            ConexaoDAO.ConectDB();
            stmt = ConexaoDAO.con.createStatement();

            String comandoInstrutorVeiculo = "INSERT INTO veiculoInstrutor (id_instrutor, placa) VALUES ("
                    + instrutorDTO.getId_instrutor() + ","
                    + "'" + veiculoDTO.getPlaca() + "')";

            stmt.execute(comandoInstrutorVeiculo);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;

        } catch (Exception err) {
            System.out.println("Erro VeiculoDAO.inserirInstrutorVeiculo: " + err.getMessage());
            return false;
        } finally {
            ConexaoDAO.ConectDB();
        }
    }

    public boolean excluirVeiculo(VeiculoDTO veiculoDTO) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            stml = ConexaoDAO.con.createStatement();

            String comandoVeiculoInstrutor = "DELETE FROM veiculoInstrutor WHERE placa = '" + veiculoDTO.getPlaca() + "'";
            stml.execute(comandoVeiculoInstrutor);

            String comandoVeiculo = "DELETE FROM veiculo WHERE placa = '" + veiculoDTO.getPlaca() + "'";
            stmt.execute(comandoVeiculo);

            ConexaoDAO.con.commit();

            stmt.close();
            stml.close();

            return true;
        } catch (Exception err) {
            System.out.println("Erro VeiculoDAO.excluirVeiculo: " + err.getMessage());
            return false;
        } finally {
            ConexaoDAO.ConectDB();
        }
    }

    public ResultSet consultarVeiculo(VeiculoDTO veiculoDTO, int opcao) {
        try {
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "SELECT v.* FROM veiculo v";
                    break;
                case 2:
                    comando = "SELECT v.* FROM veiculo v WHERE "
                            + "v.placa like '" + veiculoDTO.getPlaca() + "%'";
                    break;
                case 3:
                    comando = "SELECT * FROM veiculoinstrutor WHERE "
                            + "placa = '" + veiculoDTO.getPlaca() + "'";
            }

            rs = stmt.executeQuery(comando);

            return rs;
        } catch (Exception err) {
            System.out.println("Erro VeiculoDAO.alterarVeiculo: " + err.getMessage());
            return rs;
        }
    }

    public boolean alteraInstrutorVeiculo(VeiculoDTO veiculoDTO, int idsInstrutores[]) {
        try {
            ResultSet rs2;
            ConexaoDAO.ConectDB();

            stmt = ConexaoDAO.con.createStatement();
            stml = ConexaoDAO.con.createStatement();
           
                String comandoDeletarInstrutorVeiculo = "DELETE FROM veiculoInstrutor "
                        + "WHERE  placa = '" + veiculoDTO.getPlaca() + "'";
                
           stmt.execute(comandoDeletarInstrutorVeiculo);
                
            for (int i = 0; i < idsInstrutores.length; i++) {
                String comandoInstrutorVeiculo = "INSERT INTO veiculoInstrutor (id_instrutor, "
                        + "placa) VALUES ("
                        + "" + idsInstrutores[i] + ","
                        + "'" + veiculoDTO.getPlaca() + "')";

                stml.execute(comandoInstrutorVeiculo);

            }
            ConexaoDAO.con.commit();
            stmt.close();
            stml.close();
            return true;
        } catch (Exception err) {
            System.out.println("Erro VeiculoDAO.alterarInstrutorVeiculo: " + err.getMessage());
            return false;
        } finally {
            ConexaoDAO.ConectDB();
        }
    }

}
