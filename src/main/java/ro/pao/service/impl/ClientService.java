package ro.pao.service.impl;
import ro.pao.model.cumparator.Client;
import ro.pao.repository.impl.ClientRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService {
    private ClientRepository clientRepository;

    public ClientService() {
        clientRepository = new ClientRepository();
    }

    public void createClient(Client client) {
        String sql = "INSERT INTO clients (prnume, email, adresa, telefon) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement statement = clientRepository.getConnection().prepareStatement(sql);
            statement.setString(1, client.getPrnume());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getAdresa());
            statement.setString(4, client.getTelefon());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Client getClientById(int clientId) {
        String sql = "SELECT * FROM clients WHERE id = ?";
        Client client = null;

        try {
            PreparedStatement statement = clientRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, clientId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setPrnume(resultSet.getString("prnume"));
                client.setEmail(resultSet.getString("email"));
                client.setAdresa(resultSet.getString("adresa"));
                client.setTelefon(resultSet.getString("telefon"));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

    public void updateClient(Client client) {
        String sql = "UPDATE clients SET prnume = ?, email = ?, adresa = ?, telefon = ? WHERE id = ?";

        try {
            PreparedStatement statement = clientRepository.getConnection().prepareStatement(sql);
            statement.setString(1, client.getPrnume());
            statement.setString(2, client.getEmail());
            statement.setString(3, client.getAdresa());
            statement.setString(4, client.getTelefon());
            statement.setInt(5, client.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteClient(int clientId) {
        String sql = "DELETE FROM clients WHERE id = ?";

        try {
            PreparedStatement statement = clientRepository.getConnection().prepareStatement(sql);
            statement.setInt(1, clientId);

            int rowsDeleted = statement.executeUpdate();
            statement.close();

            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


}

