package com.pharmacie.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.pharmacie.entities.Medicament;
import com.pharmacie.tools.ConnexionDB;

public class ModelMedicament implements Model<Medicament> {
	PreparedStatement pstmt;
	ResultSet resultat;
	Medicament medicament;
	List<Medicament> medicaments = new ArrayList<>();
	@Override
	public void save(Medicament obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("insert into medicament(nomMedica,code,prix,qteStock,idcat) values(?,?,?,?,?)");
			pstmt.setString(1, obj.getNomMedica());
			pstmt.setString(2, obj.getCode());
			pstmt.setDouble(3, obj.getPrix());
			pstmt.setInt(4, obj.getQteStock());
			pstmt.setInt(5, obj.getCategorie().getId());
			pstmt.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

	@Override
	public void update(Medicament obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Medicament obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("delete from medicament where id=?");
			pstmt.setInt(1,obj.getId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Medicament find(int id) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from medicament where id=?");
			pstmt.setInt(1, id);
			resultat=pstmt.executeQuery();
			ModelCategorie modelcat = new ModelCategorie();
			while(resultat.next()) {
				medicament = new Medicament(resultat.getInt("id"),resultat.getString("nomMedica"),resultat.getString("code"),resultat.getDouble("prix"),resultat.getInt("qteStock"),modelcat.find(resultat.getInt("idcat")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return medicament;
	}

		 public Medicament findCode(String code) {
			 
			 
			 try {
					pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from medicament where code=?");
					pstmt.setString(1, code);
					resultat=pstmt.executeQuery();
					ModelCategorie modelcat = new ModelCategorie();

					while(resultat.next()) {
						medicament = new Medicament(resultat.getInt("id"),resultat.getString("nomMedica"),resultat.getString("code"),resultat.getDouble("prix"),resultat.getInt("qteStock"),modelcat.find(resultat.getInt("idcat")));
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return medicament;
		 }
	@Override
	public List<Medicament> findAll() {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from medicament");
			resultat=pstmt.executeQuery();
			ModelCategorie modelcat = new ModelCategorie();
			while(resultat.next()) {
				medicaments.add(new Medicament(resultat.getInt("id"),resultat.getString("nomMedica"),resultat.getString("code"),resultat.getDouble("prix"),resultat.getInt("qteStock"),
						modelcat.find(resultat.getInt("idcat"))));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return medicaments;
	}
	
	public int getQteStockMedicament(Medicament medicament) {
		int quantite=0;
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select qteStock from medicament where id=?");
			pstmt.setInt(1, medicament.getId());
			resultat=pstmt.executeQuery();
			ModelCategorie modelcat = new ModelCategorie();
			
			if(resultat.next()) {
				quantite=resultat.getInt("qteStock");

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return quantite;
	}

}
