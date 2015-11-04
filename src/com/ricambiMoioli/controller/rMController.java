package com.ricambiMoioli.controller;
 
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ricambiMoioli.dataSource.mySQL.SparePartAnagManager;
import com.ricambiMoioli.dataSource.mySQL.SparePartManager;
import com.ricambiMoioli.model.SparePart;
import com.ricambiMoioli.model.SparePartAnag;
 
/*
 * author: Alex Lussana
 *http://localhost:8080/ricambiMoioliSpring/rest/getAllSPs
 *localhost:8080/ricambiMoioliSpring/rest/getSP?cod=6
 *localhost:8080/ricambiMoioliSpring/rest/getSPAJSON?cod=6
 */
// 

@EnableWebMvc
/*
 * Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot adds it automatically when it sees spring-webmvc on the classpath. This flags the application as a web application and activates key behaviors such as setting up a DispatcherServlet.
 */



@RestController 
public class rMController {

	
	@RequestMapping("/welcome")
	    public SparePart getSparePArtsList() {
		   SparePart sP = new SparePart(999, "desc", "modelNum", true,  12,  23 , 34);
		   return sP;
	    }
	 
	   @RequestMapping("/addJSONSP")
	   	//@ResponseBody
	  // 	SparePart getShopInJSON(@PathVariable String name) {
	   	void addSPAsJSON() {
	//	   mySqlManager mySqlMgr = new mySqlManager();
//		   return mySqlMgr.getAllSPObject();
	   	}
	   
	   @RequestMapping("/getAllSPs")
	   ArrayList<SparePart> getSparePartListInJSON()
	   {
		   SparePartManager mySqlMgr = new SparePartManager();
		   return mySqlMgr.getAllSPObject();
		   
		   
	   }
	   @RequestMapping("/getAllSPsExtended")
	   ArrayList<SparePart> getAllSPsExtendedJSON()
	   {
		   SparePartManager mySqlMgr = new SparePartManager();
		   return mySqlMgr.getAllSPObjectExtended();
		   
		   
	   }
	   public Boolean doesItStartWithCapital(String string2Check)
	   {
	   String capitalAlphabeat = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   return !(capitalAlphabeat.indexOf(string2Check.charAt(0))==-1);
	   
	   }
	   

	   @RequestMapping("/getSP")
	   ArrayList<SparePart> getSparePartInJSON(@RequestParam(value="cod", defaultValue="0") int sPCod)
	   {
		   SparePartManager mySqlMgr = new SparePartManager();
		   return mySqlMgr.getSPObject(sPCod);
		   
	   }
	   
 
	   
	   
	   
	   
	   @RequestMapping("/getHW")
	   public String getHW()
	   {
		   return "Hello World Aleeeeeeeeeeex";
		   
		   
	   }
 
	   
	   
	   
	   /*
	    * Spare Part Anag section
	    */
	   @RequestMapping("/getAllSPAJSON")
	   public ArrayList<SparePartAnag> getAllSPA()
	   {
		   SparePartAnagManager sPAMMySQL = new SparePartAnagManager(); 
		   return sPAMMySQL.getAllSPA();
	   }
	   
	   @RequestMapping("/getSPAJSON")
	   ArrayList<SparePartAnag> getSPAJSON(@RequestParam(value="cod", defaultValue="0") int sPACod)
	   {
		   SparePartAnagManager sPAMMySQL = new SparePartAnagManager();
		   return sPAMMySQL.getSPObject(sPACod);
	   }
	   
	   @RequestMapping("/saveUpdateSPA")
	   Boolean saveUpdateSPA(@RequestParam(value="sPA") SparePartAnag sPA)
	   {
		   return false;
	   }

	   
}
 


