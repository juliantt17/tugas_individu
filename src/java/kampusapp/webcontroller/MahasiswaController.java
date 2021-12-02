
package kampusapp.webcontroller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kampusapp.dao.KampusDAO;
import kampusapp.dao.KampusDAOproses;
import kampusapp.model.Mahasiswa;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Kiki Jakaria
 */
@Controller
public class MahasiswaController {
    KampusDAO mhsDao = null;
    private Object mah;
    public MahasiswaController(){
        mhsDao=new KampusDAOproses();
    }
    @RequestMapping(value="/mahasiswa-form")
    public ModelAndView index(HttpServletRequest req, HttpServletResponse res){
        String action=req.getParameter("action");
        ModelAndView modelandview;
        if(action==null){
            action="ADD";
        }
        switch(action.toUpperCase()){
            case "EDIT":
                modelandview=editMahasiswa(req,res);
                break;
            case "DELETE":
                modelandview=deleteMahasiswa(req,res);
                break;
            default:
                modelandview=addMahasiswa(req,res);
                break;
        }
        return modelandview;
               
    }
    @RequestMapping(value="/mahasiswa-form", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("mhs") Mahasiswa mh){
        ModelAndView modelandview=new ModelAndView("redirect:/mahasiswa-form.html");
        if(mh.getId()!=0){
            if(mhsDao.update(mh)){
                return new ModelAndView("redirect:/home.html");  
            }else {
                modelandview.addObject("message", "Gagal Update Data");
            }
            
        }else{
            if(mhsDao.save(mh)){
                return new ModelAndView("redirect:/home.html");  
            }else {
                modelandview.addObject("message", "Gagal Simpan Data");
            }
            
        }
        return modelandview;
    }

   

    private ModelAndView deleteMahasiswa(HttpServletRequest req, HttpServletResponse res) {
        String id=req.getParameter("id");
        if(mhsDao.delete(Integer.parseInt(id))){
            return new ModelAndView("redirect:/home.html");
        }else{
            req.setAttribute("message", "Gagal Delete");
            return addMahasiswa(req, res);
        }
    }

    private ModelAndView addMahasiswa(HttpServletRequest req, HttpServletResponse res) {
       if(req.getParameter("message") !=null){
            ModelAndView modelandview = new ModelAndView();
            modelandview.addObject("message", req.getParameter("message"));
            return modelandview;
        }
        return new ModelAndView();
    }

    private ModelAndView editMahasiswa(HttpServletRequest req, HttpServletResponse res) {
       String id=req.getParameter("id");
       Mahasiswa mah=mhsDao.getSinggle(Integer.parseInt(id));
       ModelAndView modelandview=new ModelAndView();
       modelandview.addObject("mhs", mah);
       return modelandview;
    }
}
