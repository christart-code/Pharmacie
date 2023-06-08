package com.pharmacie.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.pharmacie.entities.Role;
import com.pharmacie.tools.ConnexionDB;

public class RoleModel implements Model<Role> {
	
  // Connection con= (Connection) ConnexionDB.getInstance();
	PreparedStatement pstmt=null;
	ResultSet resultat=null;
	List<Role> roles= new ArrayList<>();
	Role role=null;
	
	@Override
	public void save(Role obj) {
/**
 * Récuperation du Preparedstatement
 */
	try {
		 pstmt= ConnexionDB.getInstance().prepareStatement(
					"insert into role(code,nom) values(?,?)");
		pstmt.setString(1, obj.getCode());
		pstmt.setString(2, obj.getNom());
		
	//execution de la requête dans la base de données
		
		pstmt.execute();
		
		
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
		
	}
	
	

	@Override
	public void update(Role obj) {
		try {
			 pstmt= ConnexionDB.getInstance().prepareStatement(
						"update role set code=?,nom=? where id=? ");
			pstmt.setString(1, obj.getCode());
			pstmt.setString(2, obj.getNom());
			pstmt.setInt(3, obj.getId());
			
		//execution de la requête dans la base de données
			
			pstmt.execute();
			
			
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
		
	}

	@Override
	public void delete(Role obj) {
		try {
			 pstmt= ConnexionDB.getInstance().prepareStatement(
						"delete from role where id=? ");
			
			pstmt.setInt(1, obj.getId());
			
		//execution de la requête dans la base de données
			
			pstmt.execute();
			
			
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
	
	}

	@Override
	public Role find(int id) {
		try {
			 pstmt= ConnexionDB.getInstance().prepareStatement(
						"select * from role where id=? ");
						
		//execution de la requête dans la base de données
			 
		 pstmt.setInt(1, id);
		resultat=pstmt.executeQuery();
		while(resultat.next()) {
		
		 role= new Role(resultat.getInt("id"),
						resultat.getString("code"),
						resultat.getString("nom"));
		 
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
			
		return role;
	}

		
	

	@Override
	public List<Role> findAll() {
		try {
			 pstmt= ConnexionDB.getInstance().prepareStatement(
						"select * from role ");
						
		//execution de la requête dans la base de données
			
		resultat=pstmt.executeQuery();
		//Role role;
			while(resultat.next()) {
				role= new Role(resultat.getInt("id"),
						resultat.getString("code"),
						resultat.getString("nom"));
				roles.add(role);
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
			
		return roles;
	}

}
