package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchDAO;
import dto01917.ProduktBatchDTO;

public class MySQLProduktBatchDAO implements ProduktBatchDAO {
    public ProduktBatchDTO getProduktBatch(int pbId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch WHERE pb_id = " + pbId);
        try {
            if (!rs.first()) throw new DALException("produktbatch'et " + pbId + " findes ikke");
            return new ProduktBatchDTO (rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id"));
        }
        catch (SQLException e) {throw new DALException(e); }

    }

    public void createProduktBatch(ProduktBatchDTO pbId) throws DALException {
        Connector.doUpdate(
                "INSERT INTO produktbatch(pb_id, status, recept_id) VALUES " +
                        "(" + pbId.getPbId() + ", '" + pbId.getStatus() + "', '" + pbId.getReceptId() + "')"
        );
    }

    public void updateProduktBatch(ProduktBatchDTO pbId) throws DALException {
        Connector.doUpdate(
                "UPDATE produktbatch SET status = '" + pbId.getStatus() + "', recept_id =  '" + pbId.getReceptId() + "' WHERE pb_id = " +
                        pbId.getPbId()
        );
    }

    public List<ProduktBatchDTO> getProduktBatchList() throws DALException {
        List<ProduktBatchDTO> list = new ArrayList<ProduktBatchDTO>();
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatch");
        try
        {
            while (rs.next())
            {
                list.add(new ProduktBatchDTO(rs.getInt("pb_id"), rs.getInt("status"), rs.getInt("recept_id")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }


}
