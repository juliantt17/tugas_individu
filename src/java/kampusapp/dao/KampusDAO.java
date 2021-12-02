
package kampusapp.dao;

import java.util.List;
import kampusapp.model.Mahasiswa;


public interface KampusDAO {
    List<Mahasiswa> get();
    boolean save(Mahasiswa mahasiswa);
    Mahasiswa getSinggle(int id);
    boolean update(Mahasiswa mahasiswa);
    boolean delete(int id);
}
