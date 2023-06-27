package ro.pao.service.impl;

import ro.pao.application.csv.ClientActionLogger;
import ro.pao.model.produse.Carte;
import ro.pao.repository.impl.CarteRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarteService {
    private CarteRepository produsRepository;
    private ClientActionLogger actionLogger;

    public CarteService() {
        produsRepository = new CarteRepository();
        actionLogger = new ClientActionLogger();
    }

    public void createProdus(Carte produs) {
        String sql = "INSERT INTO produs (autor, sect, subsect, nume, editura, pret, nr) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = produsRepository.getConnection().prepareStatement(sql);

            statement.setString(1, produs.getAutor());
            statement.setString(2, produs.getSect());
            statement.setString(3, produs.getSubsect());
            statement.setString(4, produs.getNume());
            statement.setString(5, produs.getEditura());
            statement.setDouble(6, produs.getPret());
            statement.setInt(7, produs.getNr());


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("createCarte");
    }


//get all carti
    public ArrayList<Carte> getAllProdus() {
        ArrayList<Carte> produsList = new ArrayList<>();
        String sql = "SELECT * FROM produs";

        try {
            PreparedStatement statement = produsRepository.getConnection().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Carte produs = new Carte();
                produs.setId(resultSet.getInt("id"));
                produs.setAutor(resultSet.getString("autor"));
                produs.setSect(resultSet.getString("sect"));
                produs.setSubsect(resultSet.getString("subsect"));
                produs.setNume(resultSet.getString("nume"));
                produs.setEditura(resultSet.getString("editura"));
                produs.setPret(resultSet.getDouble("pret"));
                produs.setNr(resultSet.getInt("nr"));

                produsList.add(produs);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("getallproduse");
        return produsList;
    }

    public void updateProdus(Carte produs) {
        String sql = "UPDATE produs SET autor = ?, sect = ?, subsect = ?, nume = ?, editura = ?, pret = ?, nr = ? WHERE id = ?";

        try {
            PreparedStatement statement = produsRepository.getConnection().prepareStatement(sql);
            statement.setString(1, produs.getAutor());
            statement.setString(2, produs.getSect());
            statement.setString(3, produs.getSubsect());
            statement.setString(4, produs.getNume());
            statement.setString(5, produs.getEditura());
            statement.setDouble(6, produs.getPret());
            statement.setInt(7, produs.getNr());
            statement.setInt(8, produs.getId()); // Set the ID value for the WHERE clause


            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("updateprodus");
    }

    public boolean deleteProdus(int produsId) {
        String sql = "DELETE FROM produs WHERE id = ?";

        try {
            PreparedStatement statement = produsRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, produsId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("deleteprodus");
        return false;
    }

//    public List<Carte> getAllProdusByCosId(int cosId) {
//        String sql = "SELECT * FROM produs WHERE cos_id = ?";
//        List<Carte> produsList = new ArrayList<>();
//
//        try {
//            PreparedStatement statement = produsRepository.getConnection().prepareStatement(sql);
//            statement.setInt(1, cosId);
//
//            ResultSet resultSet = statement.executeQuery();
//
//            while (resultSet.next()) {
//                Carte produs = new Carte();
//                produs.setId(resultSet.getInt("id"));
//                produs.setAutor(resultSet.getString("autor"));
//                produs.setSect(resultSet.getString("sect"));
//                produs.setSubsect(resultSet.getString("subsect"));
//                produs.setNume(resultSet.getString("nume"));
//                produs.setEditura(resultSet.getString("editura"));
//                produs.setPret(resultSet.getDouble("pret"));
//                produs.setNr(resultSet.getInt("nr"));
//                produs.setCosid(resultSet.getInt("cos_id"));
//
//                produsList.add(produs);
//            }
//
//            resultSet.close();
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        actionLogger.logAction("getallprodbycosid");
//        return produsList;
//    }

    public Carte getProdusById(int produsId) {
        String sql = "SELECT * FROM produs WHERE id = ?";
        Carte produs = null;

        try {
            PreparedStatement statement = produsRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, produsId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                produs = new Carte();
                produs.setId(resultSet.getInt("id"));
                produs.setAutor(resultSet.getString("autor"));
                produs.setSect(resultSet.getString("sect"));
                produs.setSubsect(resultSet.getString("subsect"));
                produs.setNume(resultSet.getString("nume"));
                produs.setEditura(resultSet.getString("editura"));
                produs.setPret(resultSet.getDouble("pret"));
                produs.setNr(resultSet.getInt("nr"));

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("getprodusbyid");
        return produs;
    }



}

