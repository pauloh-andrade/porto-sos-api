package br.com.portoseguro.repositories;

import br.com.portoseguro.models.Vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepostory extends BaseRepository implements IRepository<Vehicle> {
    @Override
    public List<Vehicle> getAll() throws Exception {
        List<Vehicle> vehicles = new ArrayList<>();

        String query = """
            SELECT
                V.ID_VEICULO AS vehicleId,
                V.TP_VEICULO AS vehicleType,
                V.TP_COMBUSTIVEL AS fuelType,
                V.ST_VEICULO AS vehicleStatus,
                V.NR_RENAVAM AS renavamNumber,
                V.NR_PLACA AS plateNumber,
                V.NM_USUARIO AS userName,
                V.MT_VEICULO AS vehicleModel,
                V.LR_VEICULO AS tankCapacity,
                V.ID_SOLICITACAO AS requestId,
                V.ID_CLIENTE AS clientId,
                V.ID_APOLICE AS policyId,
                V.DT_ULTIMA_MANUTENCAO AS lastMaintenanceDate,
                V.DT_MODELO AS modelDate,
                V.DT_INICIO AS startDate,
                V.DT_FIM AS endDate,
                V.DT_FABRICACAO AS manufactureDate,
                V.DT_CADASTRO AS registrationDate,
                V.DS_VEICULO AS vehicleDescription,
                V.CP_CARGA AS cargoCapacity,
                V.CM_VEICULO AS motorCapacity,
                V.AT_VEICULO AS motorPower
            FROM
                TP_VEICULO V
            ORDER BY V.ID_VEICULO
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query))
        {
            ResultSet results = ps.executeQuery();

            while(results.next()) {
                vehicles.add(new Vehicle(
                        results.getString("vehicleType"),
                        results.getString("fuelType"),
                        results.getString("vehicleStatus").charAt(0),
                        results.getLong("renavamNumber"),
                        results.getString("plateNumber"),
                        results.getString("userName"),
                        results.getString("vehicleModel"),
                        results.getLong("tankCapacity"),
                        results.getLong("vehicleId"),
                        results.getLong("requestId"),
                        results.getLong("clientId"),
                        results.getLong("policyId"),
                        results.getDate("lastMaintenanceDate"),
                        results.getDate("modelDate"),
                        results.getDate("startDate"),
                        results.getDate("endDate"),
                        results.getDate("manufactureDate"),
                        results.getDate("registrationDate"),
                        results.getString("vehicleDescription"),
                        results.getLong("cargoCapacity"),
                        results.getLong("motorCapacity"),
                        results.getLong("motorPower")
                ));
            }

            return vehicles;
        }
    }

    @Override
    public Vehicle getById(int id) throws Exception {
        Vehicle vehicle = new Vehicle();

        String query = """
            SELECT
                V.ID_VEICULO AS vehicleId,
                V.TP_VEICULO AS vehicleType,
                V.TP_COMBUSTIVEL AS fuelType,
                V.ST_VEICULO AS vehicleStatus,
                V.NR_RENAVAM AS renavamNumber,
                V.NR_PLACA AS plateNumber,
                V.NM_USUARIO AS userName,
                V.MT_VEICULO AS vehicleModel,
                V.LR_VEICULO AS tankCapacity,
                V.ID_SOLICITACAO AS requestId,
                V.ID_CLIENTE AS clientId,
                V.ID_APOLICE AS policyId,
                V.DT_ULTIMA_MANUTENCAO AS lastMaintenanceDate,
                V.DT_MODELO AS modelDate,
                V.DT_INICIO AS startDate,
                V.DT_FIM AS endDate,
                V.DT_FABRICACAO AS manufactureDate,
                V.DT_CADASTRO AS registrationDate,
                V.DS_VEICULO AS vehicleDescription,
                V.CP_CARGA AS cargoCapacity,
                V.CM_VEICULO AS motorCapacity,
                V.AT_VEICULO AS motorPower
            FROM
                T_PTSG_VEICULO V
            WHERE
                V.ID_VEICULO = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, id);
            ResultSet results = ps.executeQuery();

            if (results.next()) {
                vehicle = new Vehicle(
                        results.getString("vehicleType"),
                        results.getString("fuelType"),
                        results.getString("vehicleStatus").charAt(0),
                        results.getLong("renavamNumber"),
                        results.getString("plateNumber"),
                        results.getString("userName"),
                        results.getString("vehicleModel"),
                        results.getLong("tankCapacity"),
                        results.getLong("vehicleId"),
                        results.getLong("requestId"),
                        results.getLong("clientId"),
                        results.getLong("policyId"),
                        results.getDate("lastMaintenanceDate"),
                        results.getDate("modelDate"),
                        results.getDate("startDate"),
                        results.getDate("endDate"),
                        results.getDate("manufactureDate"),
                        results.getDate("registrationDate"),
                        results.getString("vehicleDescription"),
                        results.getLong("cargoCapacity"),
                        results.getLong("motorCapacity"),
                        results.getLong("motorPower")
                );
            }

            return vehicle;
        }
    }
    @Override
    public void save(Vehicle vehicle) throws Exception {
        String query = """
                INSERT INTO T_PTSG_VEICULO (
                    TP_VEICULO,
                    TP_COMBUSTIVEL,
                    ST_VEICULO,
                    NR_RENAVAM,
                    NR_PLACA,
                    NM_USUARIO,
                    MT_VEICULO,
                    LR_VEICULO,
                    ID_VEICULO,
                    ID_SOLICITACAO,
                    ID_CLIENTE,
                    ID_APOLICE,
                    DT_ULTIMA_MANUTENCAO,
                    DT_MODELO,
                    DT_INICIO,
                    DT_FIM,
                    DT_FABRICACAO,
                    DT_CADASTRO,
                    DS_VEICULO,
                    CP_CARGA,
                    CM_VEICULO,
                    AT_VEICULO
                ) VALUES (
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    SEQ_VEICULO.NEXTVAL,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                    ?,
                )
                """;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setVehicleStatement(vehicle, ps);

            ps.executeUpdate();
        }
    }

    @Override
    public Vehicle update(int id, Vehicle item) throws Exception{
        Vehicle updatedVehicle = new Vehicle();

        String query = """
            UPDATE T_PTSG_VEICULO
            SET TP_VEICULO = ?,
                TP_COMBUSTIVEL = ?,
                ST_VEICULO = ?,
                NR_RENAVAM = ?,
                NR_PLACA = ?,
                NM_USUARIO = ?,
                MT_VEICULO = ?,
                LR_VEICULO = ?,
                ID_SOLICITACAO = ?,
                ID_CLIENTE = ?,
                ID_APOLICE = ?,
                DT_ULTIMA_MANUTENCAO = ?,
                DT_MODELO = ?,
                DT_INICIO = ?,
                DT_FIM = ?,
                DT_FABRICACAO = ?,
                DT_CADASTRO = ?,
                DS_VEICULO = ?,
                CP_CARGA = ?,
                CM_VEICULO = ?,
                AT_VEICULO = ?
            WHERE ID_VEICULO = ?
        """;

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            setVehicleStatement(updatedVehicle, ps);

            ps.setInt(22, id);
            ps.executeUpdate();

            return getById(id);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        String query = "DELETE FROM T_PTSG_VEICULO WHERE ID_VEICULO = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    private void setVehicleStatement(Vehicle vehicle, PreparedStatement ps) throws SQLException {
        ps.setString(1, vehicle.getVehicleType());
        ps.setString(2, vehicle.getFuelType());
        ps.setString(3, String.valueOf(vehicle.getVehicleStatus()));
        ps.setLong(4, vehicle.getRenavamNumber());
        ps.setString(5, vehicle.getPlateNumber());
        ps.setString(6, vehicle.getUserName());
        ps.setString(7, vehicle.getVehicleModel());
        ps.setLong(8, vehicle.getTankCapacity());
        ps.setLong(9, vehicle.getRequestId());
        ps.setLong(10, vehicle.getClientId());
        ps.setLong(11, vehicle.getPolicyId());
        ps.setDate(12, new Date(vehicle.getLastMaintenanceDate().getTime()));
        ps.setDate(13, new Date(vehicle.getModelDate().getTime()));
        ps.setDate(14, new Date(vehicle.getStartDate().getTime()));
        ps.setDate(15, new Date(vehicle.getEndDate().getTime()));
        ps.setDate(16, new Date(vehicle.getManufactureDate().getTime()));
        ps.setDate(17, new Date(vehicle.getRegistrationDate().getTime()));
        ps.setString(18, vehicle.getVehicleDescription());
        ps.setLong(19, vehicle.getCargoCapacity());
        ps.setLong(20, vehicle.getMotorCapacity());
        ps.setLong(21, vehicle.getMotorPower());
    }
}
