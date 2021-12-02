
package kampusapp.webcontroller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kampusapp.dao.KampusDAO;
import kampusapp.dao.KampusDAOproses;
import kampusapp.model.DatabaseConfig;
import kampusapp.model.Mahasiswa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kiki Jakaria
 */
@Controller
public class HomeController {
    KampusDAO mhsDao=null;
    public HomeController(){
        mhsDao=new KampusDAOproses();
    }
    @RequestMapping(value="/home")
    public ModelAndView home(HttpServletRequest req,HttpServletResponse Res) throws SQLException{
//        Connection connection = null;
//        connection = DatabaseConfig.openConnection();
//        if (connection != null){
//            ModelAndView modelandview = new ModelAndView();
//            modelandview.addObject("msg", "Koneksi DB Sukses.");
//            return modelandview;
//        } else {
//            ModelAndView modelandview = new ModelAndView();
//            modelandview.addObject("msg", "Koneksi DB GAGAL.");
//            return modelandview;
//        }
          return listMahasiswa(req,Res);
    }

    private ModelAndView listMahasiswa(HttpServletRequest req, HttpServletResponse Res) {
        List<Mahasiswa> list=mhsDao.get();
        ModelAndView modelandview =new ModelAndView();
        modelandview.addObject("listMahasiswa", list);
        return modelandview;
    }
    
}

