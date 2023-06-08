package com.pharmacie.test;

import com.pharmacie.entities.Categorie;
import com.pharmacie.entities.Client;
import com.pharmacie.entities.Medicament;
import com.pharmacie.entities.Role;
import com.pharmacie.entities.User;
import com.pharmacie.models.ModelCategorie;
import com.pharmacie.models.ModelClient;
import com.pharmacie.models.ModelMedicament;
import com.pharmacie.models.RoleModel;
import com.pharmacie.models.UserModel;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //création de l'objet role et user
		  Role role= new Role("cp", "chef de projet");
		  RoleModel rm=new RoleModel();
		  
		 rm.save(role);
		 /* UserModel um=new UserModel();
		  User user=new User("mokoumbou japhet","13052001",role);
		  um.save(user);*/
//		Categorie cat = new Categorie("poi", "poison");
		//ModelCategorie mc = new ModelCategorie();
		//mc.save(cat);
		//mc.findAll();
		/*Medicament med = new Medicament("paracetamol","para",1500,5,cat);
		ModelMedicament mm = new ModelMedicament();
		mm.save(med);*/
		/*ModelClient mc = new ModelClient();
		Client client = new Client("ab12","massambas","vitalys");
		mc.save(client);*/
//		ModelMedicament mm = new ModelMedicament();
//		Medicament med = new Medicament(1,"paracetamol","para",1500,5,cat);

//		System.out.println(mm.getQteStockMedicament(med));
		
	}

}
