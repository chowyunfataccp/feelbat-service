


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.feelbat.model.CacheManager;
import com.feelbat.service.IMerchantService;
import com.feelbat.vo.MerchantVo;




public class MainServiceTest extends AbstractJUnit {
	@Autowired
     private IMerchantService merchantService;
     
     
     
     @Test
     public void addMerchant() throws Exception{
    	 MerchantVo vo1 = new MerchantVo();
    	 vo1.setName("testmerchantA");
    	 merchantService.addMerchant(vo1);
    	 vo1.setMerchantid(15L);
    	 merchantService.asyncCreateQrcode(vo1);
    	 System.out.println(CacheManager.getInstance().getCurrentSceneid());
    	 Thread.sleep(10000);
     }
     
     
 }
