package ro.pao.service.impl;

import ro.pao.application.csv.ClientActionLogger;
import ro.pao.model.comanda.Cos;
import ro.pao.repository.impl.CarteRepository;
import ro.pao.repository.impl.CosRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CosService {
    private CosRepository cosRepository;
    private CarteRepository produsRepository;
    private ClientActionLogger actionLogger;

    public CosService() {
        cosRepository = new CosRepository();
        produsRepository = new CarteRepository();
        actionLogger = new ClientActionLogger();
    }

    public int createCos() {
        String sql = "INSERT INTO cos (total) VALUES (?)";
        int cosId = -1;

        try {
            PreparedStatement statement = cosRepository.getConnection().prepareStatement(sql, new String[]{"id"});
            statement.setDouble(1, 0.0);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    cosId = generatedKeys.getInt(1);
                }
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("createcos");
        return cosId;
    }

    public Cos getCosById(int cosId) {
        String sql = "SELECT * FROM cos WHERE id = ?";
        Cos cos = null;

        try {
            PreparedStatement statement = cosRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, cosId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cos = new Cos();
                cos.setId(resultSet.getInt("id"));
                cos.setTotal(resultSet.getDouble("total"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("getcosById");
        return cos;
    }

    public void updateCosTotal(int cosId, double newTotal) {
        String sql = "UPDATE cos SET total = ? WHERE id = ?";

        try {
            PreparedStatement statement = cosRepository.getConnection().prepareStatement(sql);
            statement.setDouble(1, newTotal);
            statement.setInt(2, cosId);

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        actionLogger.logAction("updatecostotal");
    }

    public boolean deleteCos(int cosId) {
        String sql = "DELETE FROM cos WHERE id = ?";

        try {
            PreparedStatement statement = cosRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, cosId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        actionLogger.logAction("deletecos");
        return false;
    }


}

