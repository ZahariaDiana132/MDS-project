package ro.pao.service.impl;

import ro.pao.application.csv.ClientActionLogger;
import ro.pao.model.comanda.generics.cossicumpbd;
import ro.pao.repository.impl.CossicumpRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CossicumpbdService {
    private CossicumpRepository cossicumpbdRepository;
    private ClientActionLogger actionLogger;
    public CossicumpbdService() {
        actionLogger = new ClientActionLogger();
        cossicumpbdRepository = new CossicumpRepository();
    }

    public int createCossicumpbd(int cumparatorId, int cosId) {
        String sql = "INSERT INTO cossicumpbd (cumparatorid, cosid) VALUES (?, ?)";
        int cossicumpbdId = 1;

        try {
            PreparedStatement statement = cossicumpbdRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, cumparatorId);
            statement.setInt(2, cosId);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cossicumpbdId = generatedKeys.getInt(1);
                }
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("createComanda");
        return cossicumpbdId;
    }

    public cossicumpbd getCossicumpbdById(int cossicumpbdId) {
        String sql = "SELECT * FROM cossicumpbd WHERE id = ?";
        cossicumpbd cossicumpbd = null;

        try {
            PreparedStatement statement = cossicumpbdRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, cossicumpbdId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cossicumpbd = new cossicumpbd();
                cossicumpbd.setId(resultSet.getInt("id"));
                cossicumpbd.setCumparatorId(resultSet.getInt("cumparatorid"));
                cossicumpbd.setCosId(resultSet.getInt("cosid"));

            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("getcomandabyid");
        return cossicumpbd;
    }

    public List<cossicumpbd> getAllCossicumpbd() {
        String sql = "SELECT * FROM cossicumpbd";
        List<cossicumpbd> cossicumpbdList = new ArrayList<>();

        try {
            PreparedStatement statement = cossicumpbdRepository.getConnection().prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                cossicumpbd cossicumpbd = new cossicumpbd();
                cossicumpbd.setId(resultSet.getInt("id"));
                cossicumpbd.setCumparatorId(resultSet.getInt("cumparatorid"));
                cossicumpbd.setCosId(resultSet.getInt("cosid"));

                cossicumpbdList.add(cossicumpbd);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("getallcomenzi");
        return cossicumpbdList;
    }



    public void deleteCossicumpbd(int cossicumpbdId) {
        String sql = "DELETE FROM cossicumpbd WHERE id = ?";

        try {
            PreparedStatement statement = cossicumpbdRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, cossicumpbdId);

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("deletecomanda");
    }


}

