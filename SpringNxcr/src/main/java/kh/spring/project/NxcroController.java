package kh.spring.project;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.tx.PlatformRequest;
import com.nexacro17.xapi.tx.PlatformResponse;
import com.nexacro17.xapi.tx.PlatformType;

@Controller
@RequestMapping("/nxcr/")
public class NxcroController {
	@RequestMapping("insert.do")
	public String insert(HttpServletRequest request) {
		System.out.println("넥사크로 요청 받음.");
		
		try {
			PlatformRequest pReq = new PlatformRequest(request.getInputStream());
			pReq.receiveData();
			
			PlatformData data = pReq.getData();
			DataSet ds = data.getDataSet("paramDS");
			
			String writer = ds.getString(0,"writer");
			String message = ds.getString(1, "message");
			
			System.out.println(writer+" : "+message);
			System.out.println("입력 처리~");
			
			// svc.insert(new MessagesDTO(0,writer,message,null));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/resources/index.html";
	}
	@RequestMapping("select.do")
	public void select(HttpServletResponse response) {
		try {
			PlatformResponse pResp = new PlatformResponse(response.getOutputStream(),PlatformType.CONTENT_TYPE_XML,"UTF-8");
			
			PlatformData data = new PlatformData();
			pResp.setData(data);
			
			DataSet ds = new DataSet("respDS");
			ds.addColumn("seq",DataTypes.INT,4);
			ds.addColumn("writer",DataTypes.STRING,256);
			ds.addColumn("message",DataTypes.STRING,3000);
			ds.addColumn("write_date",DataTypes.DATE_TIME,256);
			
			// List<MessagesDTO> list = dao.selectAll();
			
			int row = ds.newRow();
			ds.set(row,"seq",1);
			ds.set(row,"writer","jack");
			ds.set(row,"message","Hello Nxcr");
			ds.set(row,"write_date",System.currentTimeMillis());
			
			data.addDataSet(ds);
			pResp.sendData();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
