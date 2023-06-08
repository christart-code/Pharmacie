package com.pharmacie.models;

import java.util.ArrayList;
import java.util.List;

import com.pharmacie.entities.Client;
import com.pharmacie.tools.ConnexionDB;
import com.pharmacie.tools.Secure;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelClient implements Model<Client> {
	PreparedStatement pstmt;
	ResultSet resultat;
	Client client;
	List<Client> clients = new ArrayList<>();

	@Override
	public void save(Client obj) {
			try {
				pstmt=ConnexionDB.getInstance().prepareStatement("insert into client(niu,nom,prenom) values(?,?,?)");
				pstmt.setString(1, obj.getNiu());
				pstmt.setString(2, obj.getNom());
				pstmt.setString(3, obj.getPrenom());
				
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
	public void update(Client obj) {
			try {
				pstmt=ConnexionDB.getInstance().prepareStatement("update client set niu=?, nom=?, prenom=? where id=?");
				pstmt.setString(1, obj.getNiu());
				pstmt.setString(2, obj.getNom());
				pstmt.setString(3, obj.getPrenom());
				pstmt.setInt(4, obj.getId());
				
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
	public void delete(Client obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client find(int id) {
		try {
			
		pstmt=ConnexionDB.getInstance().prepareStatement("select * from client where id=?");
		pstmt.setInt(1, id);
		
		resultat=pstmt.executeQuery();
		while(resultat.next()) {
			client = new Client(resultat.getInt("id"),resultat.getString("niu"),resultat.getString("nom"),resultat.getString("prenom"));
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
		return client;
	}

	@Override
	public List<Client> findAll() {
		try {
			
			pstmt=ConnexionDB.getInstance().prepareStatement("select * from client");
			
			resultat=pstmt.executeQuery();
			while(resultat.next()) {
				clients.add(new Client(resultat.getInt("id"),resultat.getString("niu"),resultat.getString("nom"),resultat.getString("prenom"))) ; 
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
			return clients;
		
	}
	/*PreparedStatement pstmt=null;
	ResultSet resultat=null;
	List<Client> clients= new ArrayList<>();
	Client client=null;
	boolean status; 
	

	@Override
	public void save(Client obj) {
        
		try {
			pstmt= ConnexionDB.getInstance().prepareStatement(
					" insert into client(niu,nom,prenom) values(?,?,?)");
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
	public void update(Client obj) {
		try {
			pstmt= ConnexionDB.getInstance().prepareStatement(
					" update client set niu=?, nom=?,prenom=? where id=?");
			
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
	public void delete(Client obj) {
		try {
			pstmt= ConnexionDB.getInstance().prepareStatement(
					"delete from client where id=?");
			
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
	public Client find(int id) {
		try {
			pstmt=ConnexionDB.getInstance().prepareStatement("select * from client where id=?");
			pstmt.setInt(1, id);
			resultat=pstmt.executeQuery();
			while(resultat.next()) {
				Client client = new Client(resultat.getInt("id"),resultat.getString("niu"),resultat.getString("nom"),resultat.getString("prenom"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return client;
	}

	@Override
	public List<Client> findAll() {
		try {
			pstmt=ConnexionDB.getInstance().prepareStatement("select * from client");
			resultat=pstmt.executeQuery();
			
			while(resultat.next()) {
				Client client = new Client(resultat.getInt("id"),resultat.getString("niu"),resultat.getString("nom"),resultat.getString("prenom"));
				clients.add(client);
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
		
		return clients;
	}*/

}
