package com.pharmacie.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.pharmacie.entities.Livraison;
import com.pharmacie.tools.ConnexionDB;

public class ModelLivraison implements Model<Livraison> {
	PreparedStatement pstmt;
	ResultSet resultat;

	@Override
	public void save(Livraison obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("insert into livraison(dateLivrai,fournisseur) values(?,?)");
			pstmt.setString(1, obj.getDateLivrai());
			pstmt.setString(2, (obj.getFournisseur()).toString());
			pstmt.execute();
		} catch (SQLException e) {
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
	public void update(Livraison obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("update livraison set dateLivrai=? where id=?");
			pstmt.setString(1, obj.getDateLivrai());
			pstmt.execute();
		} catch (SQLException e) {
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
	public void delete(Livraison obj) {
		try {
			pstmt=(PreparedStatement) ConnexionDB.getInstance().prepareStatement("update livraison set dateLivrai=? where id=?");
			pstmt.setString(1, obj.getDateLivrai());
			pstmt.execute();
		} catch (SQLException e) {
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
	public Livraison find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livraison> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
