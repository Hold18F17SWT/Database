package daoimpl01917;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import connector01917.Connector;

import daointerfaces01917.DALException;
import daointerfaces01917.ProduktBatchKompDAO;
import dto01917.ProduktBatchKompDTO;

public class MySQLProduktBatchKompDAO implements ProduktBatchKompDAO {
    public ProduktBatchKompDTO getProduktBatchKomp(int pbId, int rbId) throws DALException {
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id = " + pbId + "AND rb_id = " + rbId);
        try {
            if (!rs.first()) throw new DALException("produktbatchkomponenten med Produkt ID " + pbId + " og RåvareBatch ID" + rbId + " findes ikke");
            return new ProduktBatchKompDTO (rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id"));
        }
        catch (SQLException e) {throw new DALException(e); }

    }

    public void createProduktBatchKomp(ProduktBatchKompDTO pbId) throws DALException {
        Connector.doUpdate(
                "INSERT INTO produktbatchkomponent(pb_id, rb_id, tara, netto, opr_id) VALUES " +
                        "(" + pbId.getPbId() + ", '" + pbId.getRbId() + "', '" + pbId.getTara() + "', '" + pbId.getNetto() + "', '" + pbId.getOprId() + "')"
        );
    }

    public void updateProduktBatchKomp(ProduktBatchKompDTO pbId) throws DALException {
        Connector.doUpdate(
                "UPDATE produktbatchkomponent SET tara = '" + pbId.getTara() + "', netto =  '" + pbId.getNetto() + "' WHERE pb_id = " +
                        pbId.getPbId()
        );
    }

    public List<ProduktBatchKompDTO> getProduktBatchKompList(int pbId) throws DALException {
        List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent WHERE pb_id =" + pbId);
        try
        {
            while (rs.next())
            {
                list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }

    public List<ProduktBatchKompDTO> getProduktBatchKompList() throws DALException {
        List<ProduktBatchKompDTO> list = new ArrayList<ProduktBatchKompDTO>();
        ResultSet rs = Connector.doQuery("SELECT * FROM produktbatchkomponent");
        try
        {
            while (rs.next())
            {
                list.add(new ProduktBatchKompDTO(rs.getInt("pb_id"), rs.getInt("rb_id"), rs.getDouble("tara"), rs.getDouble("netto"), rs.getInt("opr_id")));
            }
        }
        catch (SQLException e) { throw new DALException(e); }
        return list;
    }


}
