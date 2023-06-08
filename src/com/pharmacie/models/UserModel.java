package com.pharmacie.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pharmacie.entities.Role;
import com.pharmacie.entities.User;
import com.pharmacie.tools.ConnexionDB;
import com.pharmacie.tools.Secure;

public class UserModel implements Model<User> {
	PreparedStatement pstmt=null;
	ResultSet resultat=null;
	List<User> users= new ArrayList<>();
	User user=null;
	boolean status; 
	

	@Override
	
	public void save(User obj) {
		try {
			pstmt= ConnexionDB.getInstance().prepareStatement(
					" insert into user(username,password,role) values(?,?,?)");
			pstmt.setString(1, obj.getUsername());
			//cryptage du mot de passe
			
			pstmt.setString(2, Secure.encrypt(obj.getPassword()));
			pstmt.setInt(3, obj.getRole().getId());
			
			
		//execution de la requête dans la base de données
			
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
	public void update(User obj) {
		try {
			pstmt= ConnexionDB.getInstance().prepareStatement(
					" update user set username=?,passwd=?,role_id=? where id=?");
			pstmt.setString(1, obj.getUsername());
			//cryptage du mot de passe
			
			pstmt.setString(2, Secure.encrypt(obj.getPassword()));
			pstmt.setInt(3, obj.getRole().getId());
			pstmt.setInt(4, obj.getId());
			
		//execution de la requête dans la base de données
			
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
	public void delete(User obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		try {
			 pstmt= ConnexionDB.getInstance().prepareStatement(
						"select * from user ");
						
		//execution de la requête dans la base de données
			
		resultat=pstmt.executeQuery();
		//Role role;
		  		  
			while(resultat.next()) {
				RoleModel roleModel = new RoleModel();

				user= new User(resultat.getInt("id"),
						resultat.getString("username"),
						resultat.getString("passwd"),
						roleModel.find(resultat.getInt("role_id"))
						
				                      );
				users.add(user);
			}
			     
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	if (pstmt !=null) {
	        		try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        }

              
		
		return users;
	}
   
	public boolean isLogin(String username, String password) {
		 status = false;
		 try {
			 pstmt= ConnexionDB.getInstance().prepareStatement(
						"select * from user where username=? and password=? ");
					pstmt.setString(1, username);
					pstmt.setString(2, Secure.encrypt(password));
					
		//execution de la requête dans la base de données
			
		resultat=pstmt.executeQuery();
		
		
		  		  
			if(resultat.next()) {
				status= true;
			}else {
				status=false;
			}
			     
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	        	if (pstmt !=null) {
	        		try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        }


		 
		 
		return status;
	}
}
