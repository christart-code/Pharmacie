package com.pharmacie.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.pharmacie.entities.Categorie;
import com.pharmacie.tools.ConnexionDB;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModelCategorie implements Model<Categorie> {
	PreparedStatement pstmt;
	ResultSet resultat;
	List<Categorie> categories = new ArrayList<>();
	Categorie categorie;
	
	
	@Override
	public void save(Categorie obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("insert into categorie(code,libelle) values(?,?)");
			pstmt.setString(1, obj.getCode());
			pstmt.setString(2, obj.getLibelle());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Categorie obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("update categorie set code=?, libelle=? where id=?");
			pstmt.setString(1, obj.getCode());
			pstmt.setString(2, obj.getLibelle());
			pstmt.setInt(3, obj.getId());
			pstmt.execute();
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
		
	}

	@Override
	public void delete(Categorie obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("delete from categorie where id=?");
			pstmt.setInt(1, obj.getId());
			
			pstmt.execute();
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
		
		
	}

	@Override
	public Categorie find(int id) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from categorie where id=?");
			pstmt.setInt(1, id);
			
			resultat=pstmt.executeQuery();
			while(resultat.next()) {
				 categorie = new Categorie(resultat.getInt("id"),resultat.getString("code"),resultat.getString("libelle"));
				
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
		return categorie;
	}

	@Override
	public List<Categorie> findAll() {
		try {
			 pstmt= (PreparedStatement) ConnexionDB.getInstance().prepareStatement(
						"select * from categorie ");
						
		//execution de la requête dans la base de données
			
		resultat=pstmt.executeQuery();
		//Role role;
			while(resultat.next()) {
				categorie= new Categorie(resultat.getInt("id"),
						resultat.getString("code"),
						resultat.getString("libelle"));
				categories.add(categorie);
			}
			     
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	            finally {
	            	if (pstmt !=null) {
	            		try {
							pstmt.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            	}
	            }
			
		return categories;
	}

}
