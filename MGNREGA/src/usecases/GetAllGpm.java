package usecases;

import java.util.List;
import java.util.function.Consumer;

import com.masai.dao.BDOdao;
import com.masai.dao.BDOdaoImpl;
import com.masai.dto.Gpm;
import com.masai.dto.GpmImpl;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class GetAllGpm {

	public static void GAllGpm() {
		BDOdao bd=new BDOdaoImpl();
			try {
				List<GpmImpl> listgpm = bd.getAllGPM();
				Consumer<Gpm> con=prod->System.out.println(" aadhar-number: "+prod.getAadhar_number()+"\n"+" name: "+prod.getName()+"\n"+" date-of-birth: "+prod.getDob()+"\n"+" gender: "+prod.getGender()+"\n"+" panchayat_name: "+prod.getPanchayat_name()+"\n"+" district: "+prod.getDistrict()+"\n"+" state: "+prod.getState()+"\n"+"========================="+"\n");
				listgpm.forEach(con);
			}catch(somethingwentwrongException | NORecordFoundException ex) {
				System.out.println(ex);
			}
		}
	}


