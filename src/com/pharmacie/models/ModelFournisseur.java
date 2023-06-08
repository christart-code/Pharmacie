package com.pharmacie.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.pharmacie.entities.Client;
import com.pharmacie.entities.Fournisseur;
import com.pharmacie.tools.ConnexionDB;

public class ModelFournisseur implements Model<Fournisseur> {
	PreparedStatement pstmt;
	ResultSet resultat;
	Fournisseur fournisseur;
	List<Fournisseur> fournisseurs = new ArrayList<>();
	@Override
	public void save(Fournisseur obj) {
		 
		try {
			pstmt= (PreparedStatement) ConnexionDB.getInstance().prepareStatement(
					" insert into fournisseur(niu,nom,prenom) values(?,?,?)");
			pstmt.setString(1, obj.getNiu());
			pstmt.setString(2, obj.getNom());
			pstmt.setString(3, obj.getPrenom());
			
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
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
	}

	@Override
	public void update(Fournisseur obj) {
		try {
			pstmt= (PreparedStatement) ConnexionDB.getInstance().prepareStatement(
					" update fournisseur set niu=?, nom=?,prenom=? where id=?");
			
			pstmt.setString(1, obj.getNiu());
			pstmt.setString(2, obj.getNom());
			pstmt.setString(3, obj.getPrenom());
			pstmt.setInt(4, obj.getId());
			
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
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
	}

	@Override
	public void delete(Fournisseur obj) {
		try {
			pstmt= (PreparedStatement) ConnexionDB.getInstance().prepareStatement(
					"delete from fournisseur where id=?");
			
		pstmt.setInt(1, obj.getId());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			
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
		
	}


	@Override
	public Fournisseur find(int id) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from fournisseur where id=?");
			pstmt.setInt(1, id);
			resultat=pstmt.executeQuery();
			while(resultat.next()) {
			fournisseur = new Fournisseur(resultat.getInt("id"),resultat.getString("niu"),resultat.getString("nom"),resultat.getString("prenom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fournisseur;
	}

	@Override
	public List<Fournisseur> findAll() {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("select * from fournisseur where id=?");
			resultat=pstmt.executeQuery();
			while(resultat.next()) {
			fournisseur = new Fournisseur(resultat.getInt("id"),resultat.getString("niu"),resultat.getString("nom"),resultat.getString("prenom"));
			fournisseurs.add(fournisseur);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fournisseurs;
	}

	}


